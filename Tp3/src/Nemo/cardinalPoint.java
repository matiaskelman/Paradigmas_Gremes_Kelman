package Nemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class cardinalPoint {

    public String cardinalDirection;
    
    private static List<cardinalPoint> possibleDirections = Arrays.asList(new North(), new South(), new East(), new West());

    public static cardinalPoint getClassRelatedToSubDirection(String cardinalDirectionLookedFor){
        List<cardinalPoint> directionGottenFromFilter =
                possibleDirections
                        .stream()
                        .filter(cardinalClass -> cardinalDirectionLookedFor.equals(cardinalClass.cardinalDirection))
                        .collect(Collectors.toList());
        return directionGottenFromFilter.get(0);
    }
    
    public abstract String turnRight();

    public abstract String turnLeft();

    public abstract Coordenadas movementOnThePlain(Sub submarino);
}
