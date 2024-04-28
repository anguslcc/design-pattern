package com.pattern.factorymethod;

public abstract class Card {

  private final String sender;
  private final String receiver;

  private String music;

  protected Card(String sender, String receiver) {
    this.sender = sender;
    this.receiver = receiver;
  }

  public String getSender() {
    return sender;
  }

  public String getReceiver() {
    return receiver;
  }

  public String getMusic() {
    return music;
  }

  public void setMusic(String music) {
    this.music = music;
  }

  public abstract String getMessage();

  @Override
  public String toString() {
    return "Card{" +
        "sender='" + sender + '\'' +
        ", receiver='" + receiver + '\'' +
        ", message='" + getMessage() + '\'' +
        ", music='" + music + '\'' +
        '}';
  }
}
