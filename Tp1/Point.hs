module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show) -- Poi es una funcion que recibe 2 Int.

newP :: Int -> Int -> Point -- Nuevo Punto
newP x y= x + y
difP :: Point -> Point -> Float  -- distancia absoluta (entre puntos)
hola