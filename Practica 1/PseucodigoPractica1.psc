Algoritmo Practica_1_Lab_IPC1
	cont <- REAL
	op <- Cadena
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Escriba la opción que quiera realizar'
		Segun op  Hacer
			1:
				Encriptar
			2:
				Desencriptar
			3:
				Ataque_Texto
			4:
				Reporte
			5:
				cont <- cont-1
			De Otro Modo:
				Escribir Error
		FinSegun
	FinMientras
FinAlgoritmo

Funcion Encriptar
	Definir op Como Caracter
	Definir mensaje,textoA,textoB,cont,colum,a,B,M,a,B,C Como Real
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Escriba la opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Ingrese mensaje a encriptar'
				Dimension M[3,colum],B[3,colum],C[3,colum]
				M <- mensaje
			2:
				Escribir 'Ingrese texto con matriz A'
				Dimension a[3,3]
				a <- textoA
			3:
				Escribir 'Ingrese texto con matriz B'
				B <- textoB
			4:
				C <- (a*M)+B
			5:
				cont <- cont-1
			De Otro Modo:
				Escribir Error
		FinSegun
	FinMientras
FinFuncion

Funcion Desencriptar
	Definir op Como Caracter
	Definir mensaje,textoA,textoB Como Real
	Definir cont,colum,M,a,B,C Como Real
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Escriba la opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Ingrese mensaje a desencriptar'
				Dimension C[3,colum],M[3,colum],B[3,colum]
				C <- mensaje
			2:
				Escribir 'Ingrese texto con matriz A'
				Dimension a[3,3],Ai[3,3]
				a <- textoA
				inversa
			3:
				Escribir 'Ingrese texto con matriz B'
				B <- textoB
			4:
				M <- Ai*(C-B)
			5:
				cont <- cont-1
			De Otro Modo:
				Escribir Error
		FinSegun
	FinMientras
FinFuncion

Funcion inversa
	Escribir 'Se toma la matriz A y se calcula su determinante'
	Escribir 'Se calcula la inversa de la matriz A'
	Definir Ai Como Real
FinFuncion

Funcion Ataque_Texto
	Definir op Como Caracter
	Definir textoO,textoC Como Real
	Definir cont,filas,M1,M2,MT,a,MF1 Como Real
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Escriba la opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Ingrese texto con matriz del mensaje original'
				Dimension M1[filas,3],M2[filas,3],MT[filas,6]
				M1 <- textoO
			2:
				Escribir 'Ingrese texto con matriz del mensaje encriptado'
				M2 <- textoC
				Escribir 'La matriz MT se crea combinando la matriz M1 y M2'
			3:
				Escribir 'Proceso Gauss-Jordan en modulo 27'
				moduloinverso(MT)
				modulo(MT)
			4:
				cont <- cont-1
			De Otro Modo:
				Escribir Error
		FinSegun
	FinMientras
FinFuncion

Funcion modulo (modu)
	Si (modu MOD 27)<0ENTONCES Entonces
		modu <- (modu MOD 27)+27
	SiNo
		modul <- (modu MOD 27)
	FinSi
FinFuncion

Funcion moduloinverso(a)
	Definir inv Como Real
	Escribir 'Se calcula mediante la division de Euclidiano'
	Si a>1 Entonces
		Escribir 'No tiene inverso'
		a <- 0
	SiNo
		Escribir 'Tiene inverso'
		Si a<0 Entonces
			inv <- a+27
		SiNo
			inv <- a
		FinSi
	FinSi
FinFuncion

Funcion Reporte
	Definir cont Como Real
	Definir op Como Caracter
	cont <- 1
	Mientras cont>0 Hacer
		Escribir 'Selección la opción que quiera realizar'
		Segun op  Hacer
			1:
				Escribir 'Se genera el Reporte del proceso de Encriptación'
				Escribir 'Se abre el Reporte del proceso de Encriptación'
			2:
				Escribir 'Se genera el Reporte del proceso de Desencriptación'
				Escribir 'Se abre el Reporte del proceso de Desencriptación'
			3:
				Escribir 'Se genera el Reporte del proceso de Ataque de Texto'
				Escribir 'Se abre el Reporte del proceso de Ataque de Texto'
			4:
				cont <- cont-1
			De Otro Modo:
				Escribir Error
		FinSegun
	FinMientras
FinFuncion
