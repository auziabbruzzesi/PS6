package base;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import base.PersonDAL;




public class PersonDALTest {
	public static domain.PersonDomainModel person = new domain.PersonDomainModel();


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	person.setFirstName("Austin");
	person.setLastName("Abbruzzesi");
	person.setCity("Landenberg");
	person.setPostalCode(19350);
	person.setBirthday(new SimpleDateFormat("dd.MM.yyyy").parse("26.05.1995"));
	person.setPersonID(UUID.randomUUID());
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		PersonDAL.addPerson(person);
		assertTrue(PersonDAL.getPerson(person.getPersonID()) != null);
	}

	@After
	public void tearDown() throws Exception {
		PersonDAL.deletePerson(person.getPersonID());
		assertEquals(PersonDAL.getPersons().size(),0);
	}  
  
	@Test
	public void addPersonTest() {
		
		assertEquals(PersonDAL.getPersons().size(),1);
		
		
	}
	@Test
	public void updatePersonTest(){
		//TODO: change the name of person w/ set name
		
	}

}