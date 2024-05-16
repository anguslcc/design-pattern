package com.pattern.adapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnvelopeCreator {

  private static final Logger logger = LogManager.getLogger(EnvelopeCreator.class);

  private final Recipient recipient;

  public EnvelopeCreator(Recipient recipient) {
    this.recipient = recipient;
  }

  public void printRecipient() {
    logger.info("Name: {} ", recipient.getName());
    logger.info("Address:\n{}", recipient.getAddress());
  }
}
