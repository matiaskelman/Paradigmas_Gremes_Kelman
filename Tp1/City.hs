module City (City , newC, nameC, distanceC) where

import Point (Point , difP, newP)

data City = Cit String Point deriving (Eq, Show) -- Los objetos del type ciudad reciben un string y un point.

newC :: String -> Point -> City -- Crea una ciudad pasandole nombre de la ciudad y coordenadas (Point).
newC = Cit

nameC :: City -> String -- Devuelve el nombre de la ciudad.
nameC (Cit nombre _) = nombre

distanceC :: City -> City -> Float -- Le pasas 2 ciudades, de las ciudades toman el point y entre esos points hace difP.
distanceC (Cit _ posicion1) (Cit _ posicion2) = difP posicion1 posicion2

punto1 = newP 3 0
punto2 = newP 5 0

t :: [Bool]
t =
  [ newC "Igna" punto1 == Cit "Igna" punto1,
    newC "Mati" punto2 == Cit "Mati" punto2,
    nameC (Cit "Emilio Crack" punto1) == "Emilio Crack",
    distanceC (Cit "Igna" punto1) (Cit "Mati" punto2) == difP punto1 punto2,
    distanceC (Cit "Igna" punto1 ) (Cit "Mati" punto2) == 2,
    True
    ]
