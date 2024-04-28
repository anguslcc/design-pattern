package com.pattern.factorymethod;

import java.util.List;
import java.util.Random;

public abstract class CardFactory {

  private static final Random random = new Random();

  private static final List<String> musicList = List.of("Music A", "Music B", "Music C");

  protected abstract Card getCard(String sender, String receiver);

  public Card assembleCard(String sender, String receiver) {
    Card card = this.getCard(sender, receiver);
    card.setMusic(generateMusic());
    return card;

  }

  private String generateMusic() {
    return musicList.get(random.nextInt(musicList.size()));
  }
}
