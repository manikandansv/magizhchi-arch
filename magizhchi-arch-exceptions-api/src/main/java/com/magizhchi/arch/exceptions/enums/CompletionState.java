package com.magizhchi.arch.exceptions.enums;

/**
 * 
 * @author manisv
 *
 */
public enum CompletionState {

  /** OK completion state (no problem occurred) */
  OK,

  /** Override of this message is possible */
  OVERRIDE_POS,

  /** Correction of this message is required (e.g. error) */
  CORRECTION_REQ,

  /**
   * Undefined completion state.
   */
  UNDEFINED

}
