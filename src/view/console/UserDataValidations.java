package model.validations;

import java.util.Scanner;

import java.time.LocalDate;

public class UserDataValidations {

    static Scanner sc = new Scanner(System.in);

/**

* Pedimos que revise lo que nos escriba el usuario y verifique con el IsDigit que todo sea numeros

* @param str

* @return 

*/

    public static boolean isNumeric(String str) {

        for (int i = 0; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {

                return false;

            }

        }

        return true;

    }

/**

* El codigo revisa que todo lo que introduzcamos sean letras

* @param str

* @return 

*/

    public static boolean isAlphabetic(String str) {

        for (int i = 0; i < str.length(); i++) {

            if (!Character.isLetter(str.charAt(i))) {

                return false;

            }

        }

        return true;

    }

    // Le pedimos al codigo que verifique un dni y su tipo, en este caso, todos los diferentes a 1 daran falso

    public static boolean checkId(int typeDoc, String dni) {

        if (typeDoc != 1) {

            return false;

        }

        //Pedimos al codigo que todo lo que mida diferente a 9  o sea nulo de falso tambien

        if (dni == null || dni.length() != 9) {

            return false;

        }

        // Si el codigo contiene algo que no sea un numero desde el valor 0 al 8, tambien dara falso

        String NumerosDni = dni.substring(0, 8);

        if (!isNumeric(NumerosDni)) {

            return false;

        }

        //Si el caracter numero 8 no es una letra, sera falso, si nada coincide, nos dara cierto

        char LetraDni = dni.charAt(8);

        if (!Character.isLetter(LetraDni)) {

            return false;

        }

//        String prueba = LetraDni + "A";

//        if(!isAlphabetic(prueba)){

//            return false;

//        }

        return true;

    }

/**

* Este codigo verificara la fecha de nacimiento y la comparara con la fecha actual para calcular tu edad

* @param birthDate

* @return 

*/

    public static int calculateAge(String birthDate) {

        if (!checkFormatDate(birthDate)) {

            System.out.println("Formato Incorrecto");

            return -1;

        } else {

            String year = birthDate.substring(6, 10);

            int yearInt = Integer.parseInt(year);

            int ActualDate = LocalDate.now().getYear();

            int Years = ActualDate - yearInt;

            return Years;

        }

    }

/**

  * En este codigo verificaremos la fecha por partes, le diremos que no sobrepase los 10 valores de longitud, y separamos la fecha en tres apartados, indicando en todas que tiene que ser numerico

  * @param Date

  * @return 

  */

    public static boolean checkFormatDate(String Date) {

        if (Date == null || Date.length() != 10) {

            return false;

        }

        String[] separados = Date.split("/");

        if (separados.length != 3) {

            return false;

        }

        String day = separados[0];

        String month = separados[1];

        String year = separados[2];

        if (day.length() != 2 || month.length() != 2 || year.length() != 4) {

            return false;

        }

        if (!isNumeric(day) || !isNumeric(month) || !isNumeric(year)) {

            return false;

        }

        int intday = Integer.parseInt(day);

        int intmonth = Integer.parseInt(month);

        int intyear = Integer.parseInt(year);

        if (intmonth < 1 || intmonth > 12) {

            return false;

        }

        int maxDaysPerMonth;

        switch (intmonth) {

            case 4, 6, 9, 11:

                maxDaysPerMonth = 30;

                break;

            case 2:

                maxDaysPerMonth = 28;

                break;

            default:

                maxDaysPerMonth = 31;

                break;

        }

        if (intday < 1 || intday > maxDaysPerMonth) {

            return false;

        }

        return true;

    }

    /**

     * Aqui, valorara el tamaño de lo que recibiremos, si es diferente a 5 no se confirmara, luego veremos que este entre un rango para que este aceptado

     * @param zip

     * @return 

     */

    public static boolean checkPostalCode(String zip) {

        if (zip == null || zip.length() != 5) {

            return false;

        }

        if (!isNumeric(zip)) {

            return false;

        }

        int ziptoint = Integer.parseInt(zip);

        if (ziptoint < 1001 || ziptoint > 52001) {

            return false;

        }

        return true;

    }
// Commit try
/**

  * en este codigo, comprobara por partes que sea un correo, primero definiremos los dominios aceptados y le diremos que sin @ no es valido, luego ordenaremos que si acaba con los dominios definidos, nos lo validara

  * @param email

  * @return 

  */

    public static boolean checkEmail(String email) {

        String[] acceptedMails = {".com", ".es", ".mat", ".net", ".org"};

        if (email == null) {

            return false;

        }

        if (!email.contains("@")) {

            return false;

        }   

        if (email.startsWith("@") || email.endsWith("@")) {

            return false;

        }

        if (email.indexOf("@") != email.lastIndexOf("@")) {

            return false;

        }

        boolean dominioValido = false;

        for (int i = 0; i < acceptedMails.length; i++) {

            if (email.endsWith(acceptedMails[i])) {

                dominioValido = true;

                break;

            }

        }

        if (!dominioValido) {

            return false;

        }

        return true;

    }

    /**

     * Aqui verificamos que lo introducido sea todo alfabetico, y que este entre el rango de 2 y 20 caracteres

     * @param name

     * @return 

     */

    public static boolean checkName(String name){

        if(name == null){

            return false;   

        }

        name = name.trim();

        if(!isAlphabetic(name)){

            return false;

        }         

        if(name.length() < 2 || name.length() > 20){

            return false;

        }        

        return true;

    }

    public static void main(String[] args) {

//        System.out.println("Que tipo de documento tiene:");

//        int tipoDoc = sc.nextInt();

//        System.out.println("Introduce DNI:");        

//        String dni = sc.next();

//        if (checkId(tipoDoc,dni)) {

//            System.out.println("DNI valido");

//        } else {

//            System.out.println("DNI invalido");

//        }

//        String Date = sc.next();

//        if(!checkFormatDate(Date)){

//            System.out.println("Formato Incorrecto");

//        }

//        else{

//            System.out.println("Perfecto su fecha es: "+ Date);

//        String Variable = sc.next();        

//        System.out.println(calculateAge(Variable));

//        String date = sc.next();

//        if(!checkPostalCode(date)){

//            System.out.println("Codigo postal Incorrecto");

//        }

//        else{

//            System.out.println("Codigo postal Correcto");

//        }

//        String prueba = sc.next();

//        if (!checkEmail(prueba)){

//            System.out.println("EL formato no es el correcto");

//        }

//        else {

//            System.out.println("Tu correo es correcto: "+ prueba);

//        }

    }

}
 