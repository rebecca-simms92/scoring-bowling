package com.thehutgroup;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.anyInt;

public class GameTest {

    int TOTAL_PINS_IN_FRAME = 10;

    @Test
    public void scoreWillAlwaysBeZeroOrGreater() {
        Game game = new Game();
        assertTrue("Score is never negative", game.score() >= 0);
    }

    @Test
    public void scoreNeverExceedMaximum() {
        Game game = new Game();
        assertTrue("Score never exceed maximum of 300", game.score() <= 300);
    }

   @Test
   public void aRollWillAlwaysReturnLessThanOrTheSameNumberOfPins() {
        Game game = new Game();
        assertTrue("Number of pins left after a roll will be the same or less", game.roll(TOTAL_PINS_IN_FRAME) <= TOTAL_PINS_IN_FRAME);
   }

   @Test
   public void aRollWillNeverReturnANegativeNumberOfPins() {
      Game game = new Game();
      assertTrue("Number of pins left never negative", game.roll(anyInt()) >= 0);
   }

   @Test
   public void minimumNumberOfRollsInAGameIsTwenty() {
       Game game = new Game();
       Mockito.verify(game, Mockito.atLeast(20)).roll(anyInt());
   }

   @Test
   public void maximumNumberOfRollsInAGameIsTwentyThree() {
       Game game = new Game();
       Mockito.verify(game, Mockito.atMost(23)).roll(anyInt());
   }





}
