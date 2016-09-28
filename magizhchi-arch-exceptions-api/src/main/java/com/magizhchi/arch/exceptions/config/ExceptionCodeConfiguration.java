package com.magizhchi.arch.exceptions.config;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.magizhchi.arch.utilities.api.PropertiesUtil;

@Component(immediate = true, enabled = true, label = "ExceptionCode Factory Configuration",
           configurationFactory = true, policy = ConfigurationPolicy.REQUIRE, metatype = true)
@Service({ExceptionCodeConfiguration.class})
public class ExceptionCodeConfiguration {

  private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionCodeConfiguration.class);

  public final static String EXCEPTIONCODE_CODE = "exceptioncode.code";

  public final static String EXCEPTIONCODE_MSGID = "exceptioncode.msgId";

  public final static String EXCEPTIONCODE_SEVLEVEL = "exceptioncode.sevLevel";

  public final static String EXCEPTIONCODE_COMPLETIONSTATE = "exceptioncode.completionState";

  @Property(name = EXCEPTIONCODE_CODE, label = "Exception Code - Code")
  private String exceptionCode;

  @Property(name = EXCEPTIONCODE_MSGID, label = "Exception Code - Message Id")
  private String messageId;

  @Property(name = EXCEPTIONCODE_SEVLEVEL, label = "Exception Code - Severity Level",
            description = "Possible Values: OFF, FATAL, ERROR, WARN, INFO, DEBUG, TRACE, ALL ")
  private String severityLevel;

  @Property(name = EXCEPTIONCODE_COMPLETIONSTATE, label = "Exception Code - Completion State",
            description = "Please use any of this: OK, OVERRIDE_POS, CORRECTION_REQ, UNDEFINED")
  private String completionState;

  protected void activate(final ComponentContext ctx) {
    LOGGER.info("Activating instance of {}", this.getClass().getName());
    Dictionary<?, ?> props = ctx.getProperties();

    this.messageId = PropertiesUtil.toString(props.get(EXCEPTIONCODE_MSGID), "");
    this.severityLevel = PropertiesUtil.toString(props.get(EXCEPTIONCODE_SEVLEVEL), "");
    this.completionState = PropertiesUtil.toString(props.get(EXCEPTIONCODE_COMPLETIONSTATE), "");
  }

  public String getMessageId() {
    return messageId;
  }

  public String getSeverityLevel() {
    return severityLevel;
  }

  public String getCompletionState() {
    return completionState;
  }

  public String getExceptionCode() {
    return exceptionCode;
  }

}
