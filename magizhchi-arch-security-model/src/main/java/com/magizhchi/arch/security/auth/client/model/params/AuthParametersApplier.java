package com.magizhchi.arch.security.auth.client.model.params;

import java.util.Map;

public interface AuthParametersApplier {

  public abstract Object applyAuthParameters(Object authClientRequest,
      Map<String, Object> paramMap);

}
