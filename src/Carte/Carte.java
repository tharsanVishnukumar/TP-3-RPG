package Carte;

import Drawable.Drawable;
import Entity.GameEntity;
import Utils.GameConfig;
import Utils.Position;

import java.util.ArrayList;

public class Carte<Entity extends GameEntity> implements Drawable {
  public Carte(int width, int height) {
    this.width = width;
    this.height = height;
    entities = new ArrayList<>();
  }
  private ArrayList<Entity> entities;
  private int width;
  private int height;
  public int getWidth() {
    return width;
  }
  public int getHeight() {
    return height;
  }

  public boolean isPositionFree(Position position) {
    var entity = getEntityAtPosition(position);
    if (entity != null) {
      return false;
    }
    return true;
  }
  private Entity getEntityAtPosition(Position position) {
    for (Entity entity : entities) {
      if (entity.getPosition().equals(position)) {
        return entity;
      }
    }
    return null;
  }
  public  Entity getEntityAt(int x, int y) {
    Position position = new Position(x, y);
    return getEntityAtPosition(position);
  }
  public ArrayList<Entity> getAllEntitiesAt(Position position) {
    ArrayList<Entity> foundEntities = new ArrayList<>();
    for (Entity entity : entities) {
      if (entity.getPosition().equals(position)) {
        foundEntities.add(entity);
      }
    }
    return foundEntities;
  }

  public void addEntity(Entity entity) {
    entities.add(entity);
  }

  public void removeEntity(Entity entity){
    entities.remove(entity);
  }
  @Override
  public String draw() {
    StringBuilder sb = new StringBuilder();

    for (int y = 0; y < GameConfig.CARTE_HEIGHT; y++) {
      for (int x = 0; x < GameConfig.CARTE_WIDTH; x++) {
        Entity entity = getEntityAt(x, y);
        if (entity == null) {
          sb.append("{ } ");
        } else {
          sb.append("{" + entity.draw() + "} ");
        }
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
