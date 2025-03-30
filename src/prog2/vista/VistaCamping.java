package prog2.vista;

import prog2.model.Camping;

import java.util.Scanner;

public class VistaCamping {
    private Camping camping;

    static private enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_SUBMENU1, MENU_PRINCIPAL_SUBMENU2, MENU_PRINCIPAL_SUBMENU3,
        MENU_PRINCIPAL_OPCIO1, MENU_PRINCIPAL_OPCIO2, MENU_PRINCIPAL_SORTIR
    }

    static private enum OpcionsSubmenu1 {
        MENU_S1_OPCIO1, MENU_S1_OPCIO2, MENU_S1_OPCIO3, MENU_S1_SORTIR
    }

    static private enum OpcionsSubmenu2 {
        MENU_S2_OPCIO1, MENU_S2_OPCIO2, MENU_S2_OPCIO3, MENU_S2_OPCIO4, MENU_S2_SORTIR
    }

    static private enum OpcionsSubmenu3 {
        MENU_S3_OPCIO1, MENU_S3_OPCIO2, MENU_S3_OPCIO3, MENU_S3_SORTIR
    }

    public VistaCamping(String nomCamping) {
        this.camping = new Camping();
        this.camping.inicialitzaDadesCamping();
    }

    static private String[] descMenuPrincipal = {
            "Gestionar allotjaments",
            "Gestionar accessos",
            "Gestionar incidències",
            "Guardar camping",
            "Recuperar camping",
            "Sortir de l'aplicació"
    };

    static private String[] descMenu2 = {
            "Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Tornar enrere"
    };

    static private String[] descMenu3 = {
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Calcular i mostrar el número total d’accessos que proporcionen accessibilitat amb cotxe",
            "Calcular i mostrar el número total de metres quadrats d’asfalt dels accessos asfaltats",
            "Tornar enrere"
    };

    static private String[] descMenu4 = {
            "Llistar la informació de les incidències actuals",
            "Afegir una incidència",
            "Eliminar una incidència",
            "Tornar enrere"
    };

    private void gestioMenuAllotjaments(Scanner sc) {
        Menu<OpcionsSubmenu1> menu = new Menu<>("Gestionar Allotjaments", OpcionsSubmenu1.values());
        menu.setDescripcions(descMenu2);

        OpcionsSubmenu1 opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S1_OPCIO1:
                    // Llistar tots els allotjaments
                    try {
                        System.out.println(camping.llistarAllotjaments("tot")); // Llistar tots els allotjaments
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error al llistar els allotjaments: " + e.getMessage());
                    }
                    break;
                case MENU_S1_OPCIO2:
                    // Llistar allotjaments operatius
                    try {
                        System.out.println(camping.llistarAllotjaments("operatiu")); // Llistar allotjaments operatius
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error al llistar els allotjaments operatius: " + e.getMessage());
                    }
                    break;
                case MENU_S1_OPCIO3:
                    // Llistar allotjaments no operatius
                    try {
                        System.out.println(camping.llistarAllotjaments("no operatiu")); // Llistar allotjaments no operatius
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error al llistar els allotjaments no operatius: " + e.getMessage());
                    }
                    break;
                case MENU_S1_SORTIR:
                    System.out.println("Tornant al menú principal...");
                    break;
            }
        } while (opcio != OpcionsSubmenu1.MENU_S1_SORTIR);
    }

    private void gestioMenuAccessos(Scanner sc) {
        Menu<OpcionsSubmenu2> menu = new Menu<>("Gestionar Accessos", OpcionsSubmenu2.values());
        menu.setDescripcions(descMenu3);

        OpcionsSubmenu2 opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S2_OPCIO1:
                    // Llistar accessos oberts
                    try {
                        System.out.println(camping.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error al llistar els accessos oberts: " + e.getMessage());
                    }
                    break;
                case MENU_S2_OPCIO2:
                    // Llistar accessos tancats
                    try {
                        System.out.println(camping.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error al llistar els accessos tancats: " + e.getMessage());
                    }
                    break;
                case MENU_S2_OPCIO3:
                    // Calcular accessos accessibles
                    System.out.println("Accessos accessibles: " + camping.calculaAccessosAccessibles());
                    break;
                case MENU_S2_OPCIO4:
                    // Calcular metres quadrats d'asfalt
                    System.out.println("Metres quadrats d'asfalt: " + camping.calculaMetresQuadratsAsfalt());
                    break;
                case MENU_S2_SORTIR:
                    System.out.println("Tornant al menú principal...");
                    break;
            }
        } while (opcio != OpcionsSubmenu2.MENU_S2_SORTIR);
    }

    private void gestioMenuIncidencies(Scanner sc) {
        Menu<OpcionsSubmenu3> menu = new Menu<>("Gestionar Incidències", OpcionsSubmenu3.values());
        menu.setDescripcions(descMenu4);

        OpcionsSubmenu3 opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S3_OPCIO1:
                    // Llistar incidències
                    try {
                        System.out.println(camping.llistarIncidencies());
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error al llistar les incidències: " + e.getMessage());
                    }
                    break;
                case MENU_S3_OPCIO2:
                    // Afegir incidència
                    // Necesitarías pedir los parámetros necesarios para agregar la incidencia
                    break;
                case MENU_S3_OPCIO3:
                    // Eliminar incidència
                    // Necesitarías pedir el número de la incidencia a eliminar
                    break;
                case MENU_S3_SORTIR:
                    System.out.println("Tornant al menú principal...");
                    break;
            }
        } while (opcio != OpcionsSubmenu3.MENU_S3_SORTIR);
    }

    // Este es el método principal de control del menú
    public void iniciarMenu(Scanner sc) {
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Menú Principal", OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_PRINCIPAL_SUBMENU1:
                    gestioMenuAllotjaments(sc);
                    break;
                case MENU_PRINCIPAL_SUBMENU2:
                    gestioMenuAccessos(sc);
                    break;
                case MENU_PRINCIPAL_SUBMENU3:
                    gestioMenuIncidencies(sc);
                    break;
                case MENU_PRINCIPAL_OPCIO1:
                    // Implementar guardar el camping
                    break;
                case MENU_PRINCIPAL_OPCIO2:
                    // Implementar recuperar el camping
                    break;
                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Sortint de l'aplicació...");
                    break;
            }
        } while (opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }
}
