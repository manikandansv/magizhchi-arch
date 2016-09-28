package com.magizhchi.arch.exceptions.config;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.References;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Level;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.ComponentContext;

import com.magizhchi.arch.exceptions.enums.CompletionState;
import com.magizhchi.arch.exceptions.models.AbstractExceptionCode;

@Component(label = "Exception Code Factory Configuration Facade", immediate = true, enabled = true)
@References({@Reference(cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC,
                        referenceInterface = ExceptionCodeConfiguration.class, name = "ExceptionCodeConfiguration")})
@Service({ExceptionCodeConfigurationFacade.class})
public class ExceptionCodeConfigurationFacade {

  private final static String KEY_PROPERTY = "exceptioncode.code";

  @Reference
  private ConfigurationAdmin configAdmin;

  private ComponentContext componentContext;

  private final Map<String, String> exceptionCodeConfigMap = new HashMap<String, String>();

  public String getExceptionCodeConfigPID(String exceptionCode) {
    return exceptionCodeConfigMap.get(exceptionCode);
  }

  protected void bindExceptionCodeConfiguration(ServiceReference<?> ref) {
    synchronized (this.exceptionCodeConfigMap) {
      String key = (String) ref.getProperty(KEY_PROPERTY);
      String servicePID = (String) ref.getProperty(Constants.SERVICE_PID);
      if (servicePID != null) {
        exceptionCodeConfigMap.put(key, servicePID);
      }
    }
  }

  protected void unbindExceptionCodeConfiguration(ServiceReference<?> ref) {
    synchronized (this.exceptionCodeConfigMap) {
      String key = (String) ref.getProperty(KEY_PROPERTY);
      exceptionCodeConfigMap.remove(key);
    }
  }

  @Activate
  protected void activate(ComponentContext ctx) {
    this.componentContext = ctx;
  }

  public ComponentContext getComponentContext() {
    return componentContext;
  }

  public void setComponentContext(ComponentContext componentContext) {
    this.componentContext = componentContext;
  }

  public AbstractExceptionCode getAbstractExceptionCode(String exceptionCode) {

    String configPID = this.getExceptionCodeConfigPID(exceptionCode);

    if (StringUtils.isNotEmpty(configPID)) {

      try {

        Configuration conf = configAdmin.getConfiguration(configPID);

        Dictionary<?, ?> props =  conf.getProperties();
        
        String msgId = (String) props.get(ExceptionCodeConfiguration.EXCEPTIONCODE_MSGID);
        
        String sevLevel = (String) props.get(ExceptionCodeConfiguration.EXCEPTIONCODE_SEVLEVEL);
        
        Level severityLevel = Level.toLevel(sevLevel);
        
        String completionStateVal = (String) props.get(ExceptionCodeConfiguration.EXCEPTIONCODE_COMPLETIONSTATE);
        
        CompletionState completionState = CompletionState.valueOf(completionStateVal);
        
        return new AbstractExceptionCode(msgId, severityLevel, completionState);
        
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    return null;

  }

}
