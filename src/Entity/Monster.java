package Entity;

import Utils.GameConfig;
import Utils.Position;

public class Monster extends GameEntity {
  public Monster(Position position) {
    super("Monster", 100, position);
  }

  @Override
  public void hit(double damageCount) {
    super.hit(damageCount);
  }

  @Override
  public String draw() {
    return GameConfig.ANSI_RED + super.draw() + GameConfig.ANSI_RESET;
  }
}
