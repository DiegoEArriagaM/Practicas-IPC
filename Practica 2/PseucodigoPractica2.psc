Algoritmo Practica_2_Lab_IPC
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Escribir 'Se despliega el menú principal'
	Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
	Mientras cont>0 Hacer
		Segun op  Hacer
			1:
				CargaPokemon
			2:
				CargaEntrenador
			3:
				CargaPokeball
			4:
				CargaGimnasios
			5:
				CargaAlimentos
			6:
				AsignarPokemons
			7:
				AsignarPokeballs
			8:
				AsignarComida
			9:
				AsignarPelea
			10:
				MenuReportes
			11:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinAlgoritmo

Funcion CargaPokemon
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Se le pide al usuario que ingrese un documento csv con el listado de pokemons'
				Escribir 'Documento csv ingresado por el usuario'
				Definir LecturaDoc Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id Como Entero
				Definir Listado_Tipo,Listado_Nombre Como Caracter
				Definir Listado_Vida,Listado_Puntos Como Real
				Definir Listado_Capturado,Listado_Estado Como Logico
				Mientras LecturaDoc!='vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion CargaEntrenador
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Se le pide al usuario que ingrese un documento csv con el listado de pokemons'
				Escribir 'Documento csv ingresado por el usuario'
				Definir LecturaDoc Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id Como Entero
				Definir Listado_Nombre Como Caracter
				Mientras LecturaDoc<>'vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion CargaPokeball
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Se le pide al usuario que ingrese un documento csv con el listado de pokemons'
				Escribir 'Documento csv ingresado por el usuario'
				Definir LecturaDoc Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id Como Entero
				Definir Listado_Tipo Como Caracter
				Mientras LecturaDoc<>'vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion CargaGimnasios
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Se le pide al usuario que ingrese un documento csv con el listado de pokemons'
				Escribir 'Documento csv ingresado por el usuario'
				Definir LecturaDoc Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id Como Entero
				Definir Listado_Lugar Como Caracter
				Mientras LecturaDoc<>'vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion CargaAlimentos
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Se le pide al usuario que ingrese un documento csv con el listado de pokemons'
				Escribir 'Documento csv ingresado por el usuario'
				Definir LecturaDoc Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id Como Entero
				Definir Listado_Nombre Como Caracter
				Definir Listado_Vida Como Real
				Mientras LecturaDoc<>'vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion AsignarPokemons
	Escribir 'Se mandan a llamar los metodos CargaPokemon y CargaPokeball'
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Definir LecturaDoc Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id_Pokemon,Listado_Id_Pokeball Como Entero
				Mientras LecturaDoc<>'vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
					Escribir 'Se busca el Id del pokemon en el metodo CargaPokemon, y se esteblece al pokemon como Capturado'
					Escribir 'Se reescribe el documento ingresado por el usuario con los valores modificados'
					Escribir 'Se vuelve a ingresar el documento reciencreado en el sistema'
					CargaPokemon
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion AsignarPokeballs
	Escribir 'Se mandan a llamar los metodos CargaEntrenador y CargaPokeball'
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Definir LecturaDoc Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id_Entrenador,Listado_Id_Pokeball,ContEntrenador Como Entero
				Mientras LecturaDoc<>'vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
					Escribir 'Se aumenta en 1 el contador de Pokeballs del Entrenador en turno'
					ContEntrenador <- ContEntrenador+1
					Si ContEntrenador>5 Entonces
						Escribir 'Mensaje: En el listado un entrenador tiene mas de 5 pokeballs'
						Escribir 'Se detiene la lectura del documento'
					FinSi
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion AsignarComida
	Escribir 'Se mandan a llamar los metodos CargaPokemon y CargaAlimentos'
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Definir LecturaDoc,ListadoComidas Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id_Pokemon,Listado_Id_Comida Como Entero
				Definir Vida_Pokemon,Vida_Alimento Como Real
				Mientras LecturaDoc<>'vacío' Hacer
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
					Escribir 'Se busca el Id del pokemon en el metodo CargaPokemon, y se esteblece la vida del Pokemon'
					Escribir 'Se busca el Id del pokemon en el metodo CargaAlimentos, y se esteblece la vida que recupera'
					Vida_Pokemon <- Vida_Pokemon+Vida_Alimento
					Si Vida_Pokemon>0 Entonces
						Escribir 'Se busca el Id del pokemon en el metodo CargaPokemon, y se esteblece al pokemon como Vivo'
					FinSi
					ListadoComidas <- 'Se escribe la Actividad de Comida que se acaba de realizar'
					Escribir 'Se reescribe el documento ingresado por el usuario con los valores modificados'
					Escribir 'Se vuelve a ingresar el documento reciencreado en el sistema'
					CargaPokemon
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion AsignarPelea
	Escribir 'Se mandan a llamar los metodos CargaPokemon y CargaGimnasios'
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Definir LecturaDoc,ListadoPeleas Como Caracter
				Definir Listado_Titulo Como Caracter
				Definir Listado_Id_Pokemon1,Listado_Id_Pokemon2,Listado_Id_Gimnasio,ContPelea Como Entero
				Definir Ataque_Pokemon1,Ataque_Pokemon2,Vida_Pokemon1,Vida_Pokemon2 Como Real
				Mientras LecturaDoc<>'vacío' Hacer
					cont <- 1
					Escribir 'Se lee el documento y se asignan los valores a su determinada lista'
					Escribir 'Se busca el Id del pokemon1 en el metodo CargaPokemon, y se esteblece la vida y el ataque del Pokemon1'
					Escribir 'Se busca el Id del pokemon2 en el metodo CargaPokemon, y se esteblece la vida y el ataque del Pokemon2'
					ContPelea <- 3
					Mientras ContPelea>0 Hacer
						Vida_Pokemon2 <- Vida_Pokemon2-Ataque_Pokemon1
						Si Vida_Pokemon2<=0 Entonces
							Escribir 'Se busca el Id del pokemon2 en el metodo CargaPokemon, y se esteblece al pokemon como Muerto'
							Escribir 'Se detiene el ciclo de la batalla con un break'
							ContPelea <- 0
						FinSi
						Vida_Pokemon1 <- Vida_Pokemon1-Ataque_Pokemon2
						Si Vida_Pokemon1<=0 Entonces
							Escribir 'Se busca el Id del pokemon1 en el metodo CargaPokemon, y se esteblece al pokemon como Muerto'
							Escribir 'Se detiene el ciclo de la batalla con un break'
							ContPelea <- 0
						FinSi
						ContPelea <- ContPelea-1
					FinMientras
					Escribir 'Se reescribe el documento ingresado por el usuario con los valores modificados'
					Escribir 'Se vuelve a ingresar el documento reciencreado en el sistema'
					CargaPokemon
				FinMientras
			2:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion

Funcion MenuReportes
	Escribir 'Se mandan a llamar todos los metodos anteriores, exepto el principal'
	Definir op Como Caracter
	Definir cont Como Entero
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Se despliega el menú principal'
		Escribir 'Se le pide al usuario que ingrese el número de opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Se genera el reporte de los entrenadores y sus pokemons'
			2:
				Escribir 'Se genera el reporte de los pokemons Salvaje'
			3:
				Escribir 'Se genera el reporte de todas las actividades de comida'
			4:
				Escribir 'Se genera el reporte de todas las peleas'
			5:
				Escribir 'Se genera el reporte de los 5 pokemons con mayor ataque'
			6:
				Escribir 'Se genera el reporte de los 5 alimentos con mayor recuperación de vida'
			7:
				cont <- cont-1
			De Otro Modo:
				Escribir 'Mensaje: Ingreser un valor correcto'
		FinSegun
	FinMientras
FinFuncion
