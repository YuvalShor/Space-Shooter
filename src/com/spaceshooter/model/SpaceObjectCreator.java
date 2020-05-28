package com.spaceshooter.model;

public class SpaceObjectCreator implements SpaceObjectFactory {

    @Override
    public SpaceObject createSpaceObject(String nameOfObject, int objectX, int objectY) {
        SpaceObject spaceObjectToCreate = null;

        if(nameOfObject == "playerspaceship"){
            spaceObjectToCreate = createPlayerSpaceship(objectX, objectY);
        }
        else if(nameOfObject == "enemyspaceship"){
            spaceObjectToCreate = createEnemySpaceship(objectX, objectY);
        }
        else if(nameOfObject == "laserbeam"){
            spaceObjectToCreate = createLaserbeam(objectX, objectY);
        }
        else if(nameOfObject == "star"){
            spaceObjectToCreate = createStar(objectX, objectY);
        }
        else if(nameOfObject == "explosion"){
            spaceObjectToCreate = createExplosion(objectX, objectY);
        }
        else{
            throw new IllegalArgumentException("Object name does not exist");
        }

        return spaceObjectToCreate;
    }

    private Star createStar(int starX, int starY){
        // to implement
        return null;
    }

    private PlayerSpaceship createPlayerSpaceship(int starX, int starY){
        // to implement
        return null;
    }

    private Laserbeam createLaserbeam(int starX, int starY){
        // to implement
        return null;
    }

    private EnemySpaceship createEnemySpaceship(int starX, int starY){
        // to implement
        return null;
    }

    private Explosion createExplosion(int starX, int starY){
        // to implement
        return null;
    }
}
