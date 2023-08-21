module City (City (..), newC, nameC, distanceC) where

import Point (Point (..), difP, newP)

data City = Cit String Point deriving (Eq, Show) -- Los objetos del type ciudad reciben un string y un point.

newC :: String -> Point -> City -- Crea una ciudad pasandole nombre de la ciudad y coordenadas (Point).
newC = Cit

nameC :: City -> String -- Devuelve el nombre de la ciudad.
nameC (Cit nombre _) = nombre

distanceC :: City -> City -> Float -- Le pasas 2 ciudades, de las ciudades toman el point y entre esos points hace difP.
distanceC (Cit _ posicion1) (Cit _ posicion2) = difP posicion1 posicion2

t :: [Bool]
t =
  [ newC "Igna" (Poi 1 0) == Cit "Igna" (Poi 1 0),
    newC "Mati" (Poi 0 1) == Cit "Mati" (Poi 0 1),
    nameC (Cit "Emilio Crack" (Poi 0 0)) == "Emilio Crack",
    distanceC (Cit "Igna" (Poi 1 0) ) (Cit "Mati" (Poi 0 1)) == difP (Poi 1 0) (Poi 0 1),
    distanceC (Cit "Igna" (Poi 4 0) ) (Cit "Mati" (Poi 3 0)) == 1,
    True
  ]