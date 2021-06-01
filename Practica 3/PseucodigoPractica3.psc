Algoritmo Practica_3
	Escribir 'Abrir Ventana de Inicio'
	Segun 'Boton Pulsado por el usuario'  Hacer
		'Nuevo Juevo':
			Escribir 'Empieza el juego'
			Segun 'Final del Juego'  Hacer
				'Eliminado todos los invasores':
					Escribir 'Se detienen todos los hilos'
					Escribir 'Se suma el tiempo al puntaje actual'
				'Se acabo el tiempo':
					Escribir 'Se detienen todos los hilos'
				'Los aliens llegan al extremo izquierdo de la pantalla':
					Escribir 'Se detienen todos los hilos'
			FinSegun
			Escribir 'Se le pide al jugador que ingrese un nombre'
			Definir nombre Como Caracter
			Leer nombre
			Escribir 'Se guarda el puntaje con el nombre'
			Escribir 'Se cierra la ventana'
			Escribir 'Se regresa a la ventana de inicio'
		'Configuracion':
			Escribir 'Se abre ventana de configuracion'
			Segun 'Boton que pulsa el usuario'  Hacer
				'Guardar':
					Escribir 'Se guarda la configuracion'
				'Salir':
					Escribir 'Se cierra la ventana'
					Escribir 'Se abre la ventana de inicio'
			FinSegun
		'Puntuacion Maxima':
			Escribir 'Se muestra un listado con los 5 mejores puntajes'
			Si 'Se toca el boton Salir' Entonces
				Escribir 'Se regresa a la ventana de inicio'
			FinSi
		'Salir':
			Escribir 'Se cierra la ventana'
			Escribir 'Se sale del programa'
	FinSegun
FinAlgoritmo
