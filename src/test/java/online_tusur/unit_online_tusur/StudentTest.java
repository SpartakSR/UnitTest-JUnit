package online_tusur.unit_online_tusur;

import online_tusur.unit_online_tusur.Student;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.*;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;


public class StudentTest {
	/*объект тестового класса  Student*/
	private Student s = new Student();	 	   


/*==============================================================================================================*/
/* Динамический тест для геттера getAge()*/
	
	@TestFactory
	@Tag ("negative")
	Collection<DynamicTest> dynamicTest1() {

	List<Integer> act = Arrays.asList(17,18,50,51);
	List<Integer> exp = Arrays.asList(18,18,50,18);

	// ArrayList<DynamicNode> res = new ArrayList<>();
	ArrayList<DynamicTest> res = new ArrayList<DynamicTest>();

	//перебираем в цикле все элементы коллекции-списка act
	for (int i = 0; i < act.size(); i++) {

	int x,y;
	s.setAge(act.get(i));
	y=s.getAge();
	x=exp.get(i);

	// создаем на каждой итерации выполнение теста
	Executable exec = () -> assertEquals(x, y);

	//здесь формируем один тест из отображаемого имени, которое мы будем видеть в отчете JUnit и расширения Executable на каждой итерации, итого у нас в примере будет 3 таких теста
	DynamicTest dTest = dynamicTest("test"+i+". age="+x+"}",exec);

	//записываем тест в коллецию res на каждой итерации цикла
	res.add(dTest);
	}

	return res;
	}
	
/*---------------------------------------------------------------------------------------------------------------*/	
/* Динамический тест для геттера getLastName()*/
	@TestFactory
	@Tag("negative")
	Collection<DynamicTest> dynamicTest2() {

	List<String> act = Arrays.asList("Ivanov","pETROV","SIDOROV","konev","A","n");
	List<String> exp = Arrays.asList("Ivanov","Petrov","Sidorov","Konev","A","N");

	// ArrayList<DynamicNode> res = new ArrayList<>();
	ArrayList<DynamicTest> res = new ArrayList<DynamicTest>();

	//перебираем в цикле все элементы коллекции-списка act
	for (int i = 0; i < act.size(); i++) {

	String x,y;
	s.setLastName(act.get(i));
	y=s.getLastName();
	x=exp.get(i);

	// создаем на каждой итерации выполнение теста
	Executable exec = () -> assertEquals(x, y);

	//здесь формируем один тест из отображаемого имени, которое мы будем видеть в отчете JUnit и расширения Executable на каждой итерации, итого у нас в примере будет 3 таких теста
	DynamicTest dTest = dynamicTest("test"+i+". LastName="+x+"}",exec);

	//записываем тест в коллецию res на каждой итерации цикла
	res.add(dTest);
	}

	return res;
	}
	
/*---------------------------------------------------------------------------------------------------------------*/		
/* Динамический тест для геттера getFirstName()*/
	@TestFactory
	@Tag("positive")
	Collection<DynamicTest> dynamicTest3() {

	List<String> act = Arrays.asList("Ivan","pETR","TIMUR","damir","A","n");
	List<String> exp = Arrays.asList("Ivan","Petr","Timur","Damir","A","N");

	// ArrayList<DynamicNode> res = new ArrayList<>();
	ArrayList<DynamicTest> res = new ArrayList<DynamicTest>();

	//перебираем в цикле все элементы коллекции-списка act
	for (int i = 0; i < act.size(); i++) {

	String x,y;
	s.setFirstName(act.get(i));
	y=s.getFirstName();
	x=exp.get(i);

	// создаем на каждой итерации выполнение теста
	Executable exec = () -> assertEquals(x, y);

	//здесь формируем один тест из отображаемого имени, которое мы будем видеть в отчете JUnit и расширения Executable на каждой итерации, итого у нас в примере будет 3 таких теста
	DynamicTest dTest = dynamicTest("test"+i+". FirstName="+x+"}",exec);

	//записываем тест в коллецию res на каждой итерации цикла
	res.add(dTest);
	}

	return res;
	}	
	
/*===============================================================================================================*/	
/* Параметизированный тест расчета среднего возраста студентов */
	
	@ParameterizedTest
	@Tag ("positive")
	@CsvSource({"Иванов, Сергей, 20, Петров, Вася, 30, Казыбек, Вано, 40, Сидоров, Иван, 18"})
	void test_AVG2(ArgumentsAccessor reading) {

	Student [] medavg = {new Student(reading.getString(0), reading.getString(1), reading.getInteger(2)),
	new Student(reading.getString(3), reading.getString(4), reading.getInteger(5)),
	new Student(reading.getString(6), reading.getString(7), reading.getInteger(8)),
	new Student(reading.getString(9), reading.getString(10), reading.getInteger(11))};
	assertEquals(Student.avgAge(medavg), 27);
	}
	
/*==============================================================================================================*/	
	
/* Проверка возраста студента, входящего в диапазон */
	  @Test
	  @Tag ("positive")
	  void test_assert1() {
		s.setAge(18);
	    assertEquals(18, s.getAge());	
	  }
	  
/* Проверка возраста студента, входящего в диапазон */
	  @Test
	  @Tag ("negative")
	  void test_assert2() {
		s.setAge(50);
	    assertEquals(50, s.getAge());
	  }
	  
/* Проверка возраста студента, выходящего за диапазон */
	  @Test
	  @Tag ("positive")
	  void test_assert3() {
	 	s.setAge(17);
	 	assertEquals(18, s.getAge());	
	 }
	  
/* Проверка возраста студента, выходящего за диапазон */
	  @Test
	  @Tag ("positive")
	  void test_assert4() {
	 	s.setAge(51);
	 	assertEquals(18, s.getAge());	
	 }

/* Проверка метода расчета среднего возраста студентов */
	  @Test
	  @Tag ("positive")
	  void test_AVG() {
	    Student[] students2 = {new Student("ivan", "sidorov", 20), new Student("IVAN", "NIKULIN", 18),
					new Student("kONSTANTIN","pETROV", 40), new Student("Mihail","Petrov", 30)};
	 	assertEquals(27, Student.avgAge(students2));	
	 }
/* Проверка метода расчета максимального возраста студентов */
	  @Test
	  @Tag ("positive")
	  void test_MAX() {
	    Student[] students2 = {new Student("ivan", "sidorov", 17), new Student("IVAN", "NIKULIN", 18),
					new Student("kONSTANTIN","pETROV", 49), new Student("Mihail","Petrov", 40)};
	 	assertEquals(49, Student.maxAge(students2));	
	 }
/* Проверка метода расчета минимального возраста студентов */
	  @Test
	  @Tag ("positive")
	  void test_MIN() {
	    Student[] students2 = {new Student("ivan", "sidorov", 20), new Student("IVAN", "NIKULIN", 18),
					new Student("kONSTANTIN","pETROV", 40), new Student("Mihail","Petrov", 45)};
	 	assertEquals(18, Student.minAge(students2));	
	 }
/* Проверка регистра записи фамилии и имени студентов */
	  @Test
	  @Tag ("positive")
	  void test_name() {
	    s.setFirstName("iVaN");
		s.setLastName("sIdOrOv");
	 	assertEquals(s.getFullName(),("Sidorov Ivan"));	
	 }
	  
}