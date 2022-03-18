package com.dwwm.main;

public class Sortie {
	enum ok {					//Enum�ration de moyen d'identifi� des appel avec leur nom   (OK)
		CODE,
		TRANSACTION,
		RESTE,
		RETRAIT,
		MERCI,
		DEMANDE,
		VOULUE,
	}
	
	enum ko {					//Enum�ration de moyen d'identifi� des appel avec leur nom   (KO)
		CODE,     // 0
		MONTANT,  // 1
		FONDS,    // 2...
		PAUVRE,
		TICKET,
	}
	
	public static void avec_code(Sortie.ko out_u) {																							//SI Sortie.avec_code = Sortie.ko
		switch (out_u) {																														//Switch
			case MONTANT: 																															//SI out_u = MONTANT
				System.out.println("Nous ne donnons de la monaie que par : 10� 20� ou 50� merci de rentrer un montant valide");							//Afficher cette ligne
				break;																																	//Fin du si 
			case CODE: 																																//SI out_u = CODE
				System.out.println("Code invalide");																									//Afficher cette ligne
				break;																																	//Fin du si 
			case FONDS:																																//SI out_u = FONDS
				System.out.println("L'ATM ne poss�de plus les fonds nessecaire. Merci pour votre compr�hension");										//Afficher cette ligne
				break;																																	//Fin du si 
			case PAUVRE:																															//SI out_u = PAUVRE
				System.out.println("Vous n'avez plus assez d'argent sur votre compte bancaire pour effectu� ce retrait.");								//Afficher cette ligne
				break;																																	//Fin du si 
			case TICKET:																															//SI out_u = TICKETS
				System.out.println("Vous ne pouvez pas avoir de recue il ne reste plus de ticket.");													//Afficher cette ligne
				break;																																	//Fin du si 
		}//fin de switch
	}//fin function Sortie avec_code KO
	
	public static void avec_code(Sortie.ok out_u) {																							//SI Sortie.avec_code = Sortie.ok
		switch(out_u) {																															//Switch
			case CODE:																																//SI out_u = CODE
				System.out.println("Code Valid� !");																									//Afficher cette ligne
				break;																																	//Fin du si 
			case VOULUE:																															//SI out_u = CODE
				System.out.println("Combien souhaitez vous retirer ?");																					//Afficher cette ligne
				break;																																	//Fin du si
			case TRANSACTION:																														//SI out_u = CODE
				try {																																	//Essaie de
					System.out.print("Transaction en cours");																								//Afficher cette ligne
					Thread.sleep(1000);																														//attendre 1 seconde
					System.out.print(".");																													//Afficher cette ligne
					Thread.sleep(1000);																														//attendre 1 seconde
					System.out.print(".");																													//Afficher cette ligne
					Thread.sleep(1000);																														//attendre 1 seconde
					System.out.println(". ");																												//Afficher cette ligne
					Thread.sleep(1000);																														//attendre 1 seconde
				} catch (InterruptedException e) {																										//on r�cup�re l'erreur si y'a une erreur
					// TODO Auto-generated catch block
					e.printStackTrace();																													//on affiche l'erreur
				}
				break;																																	//Fin du si
			case RESTE:																																//SI out_u = CODE
				System.out.print("Il vous reste actuellement : ");																						//Afficher cette ligne
				break;																																	//Fin du si
			case RETRAIT:																															//SI out_u = CODE
				System.out.println("Veuillez r�cuperer votre argent.");																					//Afficher cette ligne
				break;																																	//Fin du si
			case MERCI:																																//SI out_u = CODE
				System.out.println("Merci pour votre fid�lit� !");																						//Afficher cette ligne
				break;																																	//Fin du si
			case DEMANDE:																															//SI out_u = CODE
				System.out.print("Veuillez rentrer votre code : ");																						//Afficher cette ligne
				break;																																	//Fin du si
			default: break;																															//Par d�faut Fin du switch
		}//fin de switch
	}//fin function Sortie avec_code OK
}//fin public class Sortie