module City ( City(..), newC, nameC, distanceC )
   where

import Point ( Point(..), newP, difP )

data City = Cit String Point deriving (Eq, Show) --Los objetos del type ciudad reciben un string y un point.

newC :: String -> Point -> City --Crea una ciudad pasandole nombre de la ciudad y coordenadas (Point).
newC = Cit
nameC :: City -> String -- Devuelve el nombre de la ciudad.
nameC (Cit nombre _ ) = nombre 
distanceC :: City -> City -> Float --Le pasas 2 ciudades, de las ciudades toman el point y entre esos points hace difP.
distanceC (Cit _ posicion1) (Cit _ posicion2) = difP posicion1 posicion2
   