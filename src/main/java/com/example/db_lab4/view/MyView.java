package com.example.db_lab4.view;
import com.example.db_lab4.controller.CoridorController;
import com.example.db_lab4.controller.ObjectController;
import com.example.db_lab4.controller.RoomController;
import com.example.db_lab4.controller.UserController;
import com.example.db_lab4.controller.SensorController;
import com.example.db_lab4.controller.ZoneController;
import com.example.db_lab4.domain.Coridor;
import com.example.db_lab4.domain.Zone;
import com.example.db_lab4.domain.User;
import com.example.db_lab4.domain.Room;
import com.example.db_lab4.domain.Object;
import com.example.db_lab4.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {
    @Autowired
    private CoridorController coridorController;
    @Autowired
    private UserController userController;
    @Autowired
    private ObjectController objectController;
    @Autowired
    private RoomController roomController;
    @Autowired
    private SensorController sensorController;
    @Autowired
    private ZoneController zoneController;

    final Map<String, String> menu;
    final Map<String, Printable> methodsMenu;
    final Scanner input = new Scanner(System.in);
    final Coridor nullCoridor = new Coridor(null, null);
    final User nullUser = new User(null, null, null, null, null, null);
    final Zone nullZone = new Zone(null, null);
    final Room nullRoom = new Room(null, null);
    final Object nullObject = new Object(null,null,null);
    final Sensor nullSensor = new Sensor(null, null,null,null,null);

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Coridor");
        menu.put("11", "  11 - Create Coridor");
        menu.put("12", "  12 - Update Coridor");
        menu.put("13", "  13 - Delete from Coridor");
        menu.put("14", "  14 - Find all Coridor");
        menu.put("15", "  15 - Find Coridor by ID");
        menu.put("16", "  16 - Find Coridor by usage");

        menu.put("2", "   2 - Table: User");
        menu.put("21", "  21 - Create User");
        menu.put("22", "  22 - Update User");
        menu.put("23", "  23 - Delete from User");
        menu.put("24", "  24 - Find all Users");
        menu.put("25", "  25 - Find User by ID");

        menu.put("3", "   3 - Table: Room");
        menu.put("31", "  31 - Create Room");
        menu.put("32", "  32 - Update Room");
        menu.put("33", "  33 - Delete from Room");
        menu.put("34", "  34 - Find all Room");
        menu.put("35", "  35 - Find Room by ID");

        menu.put("4", "   4 - Table: Sensor");
        menu.put("41", "  41 - Create Sensor");
        menu.put("42", "  42 - Update Sensor");
        menu.put("43", "  43 - Delete from Sensor");
        menu.put("44", "  44 - Find all Sensor");
        menu.put("45", "  45 - Find Sensor by ID");

        menu.put("5", "   5 - Table: Object");
        menu.put("51", "  51 - Create Object");
        menu.put("52", "  52 - Update Object");
        menu.put("53", "  53 - Delete from Object");
        menu.put("54", "  54 - Find all Object");
        menu.put("55", "  55 - Find Object by ID");

        menu.put("6", "   64 - Table: Zone");
        menu.put("61", "  61 - Create Zone");
        menu.put("62", "  62 - Update Zone");
        menu.put("63", "  63 - Delete from Zone");
        menu.put("64", "  64 - Find all Zone");
        menu.put("65", "  65 - Find Zone by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createCoridor);
        methodsMenu.put("12", this::updateCoridor);
        methodsMenu.put("13", this::deleteFromCoridor);
        methodsMenu.put("14", this::findAllCoridors);
        methodsMenu.put("15", this::findCoridorById);
        methodsMenu.put("16", this::findCoridorByUsage);


        methodsMenu.put("21", this::createUser);
        methodsMenu.put("22", this::updateUser);
        methodsMenu.put("23", this::deleteFromUser);
        methodsMenu.put("24", this::findAllUsers);
        methodsMenu.put("25", this::findUserById);

        methodsMenu.put("31", this::createSensor);
        methodsMenu.put("32", this::updateSensor);
        methodsMenu.put("33", this::deleteFromSensor);
        methodsMenu.put("34", this::findAllSensors);
        methodsMenu.put("35", this::findAllSensorsById);
        methodsMenu.put("36", this::findSensorById);

        methodsMenu.put("41", this::createObject);
        methodsMenu.put("42", this::updateTrip);
        methodsMenu.put("43", this::deleteFromObject);
        methodsMenu.put("44", this::findAllObjects);
        methodsMenu.put("45", this::findObjectById);


    }
    private void selectAllTable() {

        findAllCoridors();

        findAllSensors();

        findAllUsers();

    }
    // region CAR ---------------------------------------------------
    private void createCoridor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'usage': ");
        String usage = input.nextLine();
        Coridor coridor = new Coridor(id, usage);

        int count = coridorController.create(coridor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCoridor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'usage': ");
        String usage = input.nextLine();
        Coridor coridor = new Coridor(id, usage);

        int count = coridorController.update(id, null);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCoridor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = coridorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCoridors() {
        System.out.println("\nTable: CAR");
        List<Coridor> coridors = coridorController.findAll();
        for (Coridor coridor : coridors) {
            System.out.println(coridor);
        }
    }

    private void findCoridorById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Coridor> car = coridorController.findById(id);
        System.out.println(car.orElse(nullCoridor));
    }

    private void findCoridorByUsage() {
        System.out.println("Input 'car brand': ");
        String usage = input.nextLine();

        Optional<Coridor> car = coridorController.findByUsage(usage);
        System.out.println(car.orElse(nullCoridor));
    }

    //endregion CAR


    // region USER ------------------------------------------
    private void createUser() {
        System.out.println("Input 'user id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user lvl': ");
        Integer lvl = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user age': ");
        Integer age = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user name': ");
        String name = input.nextLine();
        System.out.println("Input 'user email': ");
        String email = input.nextLine();
        System.out.println("Input 'user sirname': ");
        String sirname = input.nextLine();

        User user = new User(id, lvl, name, sirname, age, email);

        int count = userController.create(user);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateUser() {
        System.out.println("Input 'user id': ");
        Integer iduser = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user lvl': ");
        Integer lvl = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user age': ");
        Integer age = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'user name': ");
        String name = input.nextLine();
        System.out.println("Input 'user email': ");
        String email = input.nextLine();
        System.out.println("Input 'user sirname': ");
        String sirname = input.nextLine();

    }

    private void deleteFromUser() {
        System.out.println("Input 'user id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = userController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllUsers() {
        System.out.println("\nTable: USER");
        List<User> users = userController.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void findUserById() {
        System.out.println("Input 'user name': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<User> user = userController.findById(id);
        System.out.println(user.orElse(nullUser));
    }

    private void createSensor() {
        System.out.println("Input 'name': ");
        Integer id = Integer.valueOf((input.nextLine()));
        String info = input.nextLine();
        String clas = input.nextLine();
        System.out.println("Input 'rating': ");
        String alertinfo = input.nextLine();
        System.out.println("Input 'is driver vacant(0 - false, 1 - true)': ");
        String alertSettings = input.nextLine();

        Sensor sensor = new Sensor(id, clas, info, alertinfo, alertSettings);

        int count = sensorController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSensor() {
        System.out.println("Input 'id': ");
        Integer idsensor = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String info = input.nextLine();
        System.out.println("Input 'rating': ");
        String alertInfo = input.nextLine();
        System.out.println("Input 'completed orders': ");
        String alerSettings = input.nextLine();
        System.out.println("Input 'is driver vacant(0 - false, 1 - true)': ");
        String clas = input.nextLine();

        Sensor sensor = new Sensor(idsensor, info, clas, alertInfo, alerSettings);

        int count = sensorController.update(idsensor, sensor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = sensorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSensors() {
        System.out.println("\nTable: DRIVER");
        List<Sensor> sensors = sensorController.findAll();
        for (Sensor sensor : sensors) {
            System.out.println(sensor);
        }
    }

    private void findSensorById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Sensor> driver = sensorController.findById(id);
        System.out.println(driver.orElse(nullSensor));
    }

    private void findAllSensorsById() {
        System.out.println("Input 'coridor id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Sensor> sensors = sensorController.findById(id);

            System.out.println(sensors);
    }



    private void createObject() {
        System.out.println("Input 'start_point': ");
        Integer idobject = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'end_point': ");
        String name = input.nextLine();
        System.out.println("Input 'end_point': ");
        String adress = input.nextLine();;

        Object object = new Object(idobject, name, adress);

        int count = objectController.create(object);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateTrip() {
        System.out.println("Input 'id': ");
        Integer idobject = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'start_point': ");
        String name = input.nextLine();
        System.out.println("Input 'end_point': ");
        String adress = input.nextLine();
        System.out.println("Input 'driver_id': ");

        Object object = new Object(idobject, name, adress);

        int count = objectController.update(idobject, object);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromObject() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = objectController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllObjects() {
        System.out.println("\nTable: TRIP");
        List<Object> objects = objectController.findAll();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    private void findObjectById() {
        System.out.println("Input 'id': ");
        Integer idobject = Integer.valueOf((input.nextLine()));

        Optional<Object> object = objectController.findById(idobject);
        System.out.println(object.orElse(nullObject));
    }



    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }


}

