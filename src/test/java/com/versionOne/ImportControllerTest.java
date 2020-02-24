package com.versionOne;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ImportControllerTest {

	// bind the above RANDOM_PORT
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getBranches() throws Exception {
		String json = "[\n" + "  {\n" + "    \"name\": \"Sofia Western Branch\",\n"
				+ "    \"town\": \"Sofia\"\n" + "  },\n" + "  {\n" + "    \"name\": \"Tokyo Main Branch\",\n"
				+ "    \"town\": \"Tokyo\"\n" + "  },\n" + "  {\n" + "    \"name\": \"Headquarters\",\n"
				+ "    \"town\": \"Sofia\"\n" + "  },\n" + "  {\n"
				+ "    \"name\": \"Dublin Central Branch\",\n" + "    \"town\": \"Dublin\"\n" + "  },\n"
				+ "  {\n" + "    \"name\": \"Tokyo Underground Branch\",\n" + "    \"town\": \"Tokyo\"\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"USA Main Branch\",\n"
				+ "    \"town\": \"Washington DC\"\n" + "  },\n" + "  {\n"
				+ "    \"name\": \"Sofia Eastern Branch\",\n" + "    \"town\": \"Sofia\"\n" + "  },\n" + "  {\n"
				+ "    \"name\": \"Central Park Branch\",\n" + "    \"town\": \"New York\"\n" + "  },\n"
				+ "  {\n" + "    \"name\": \"New York Central\",\n" + "    \"town\": \"New York\"\n" + "  },\n"
				+ "  {\n" + "    \"name\": \"Sidney Central Branch\",\n" + "    \"town\": \"Sidney\"\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Delhi Western Branch\",\n" + "    \"town\": \"Delhi\"\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Bangalore Central Branch\",\n"
				+ "    \"town\": \"Bangalore\"\n" + "  },\n" + "  {\n"
				+ "    \"name\": \"Mexico Main Branch\",\n" + "    \"town\": \"Mexico City\"\n" + "  },\n"
				+ "  {\n" + "    \"name\": \"Delhi Eastern Branch\",\n" + "    \"town\": \"Delhi\"\n" + "  },\n"
				+ "  {\n" + "    \"name\": \"Moscow Central Branch\",\n" + "    \"town\": \"Moscow\"\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Rio De Janeiro Branch\",\n"
				+ "    \"town\": \"Rio De Janeiro\"\n" + "  },\n" + "  {\n"
				+ "    \"name\": \"Sofia Northern Branch\",\n" + "    \"town\": \"Sofia\"\n" + "  },\n"
				+ "  {\n" + "    \"name\": \"Sofia Southern Branch\",\n" + "    \"town\": \"Sofia\"\n" + "  }\n"
				+ "]\n";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(json, headers);

		ResponseEntity<String> response = restTemplate.exchange("/import/branches", HttpMethod.POST, entity,
				String.class);

		String expectedJson = "Successfully imported Branch Sofia Western Branch.\n"
				+ "Successfully imported Branch Tokyo Main Branch.\n"
				+ "Successfully imported Branch Headquarters.\n"
				+ "Successfully imported Branch Dublin Central Branch.\n"
				+ "Successfully imported Branch Tokyo Underground Branch.\n"
				+ "Successfully imported Branch USA Main Branch.\n"
				+ "Successfully imported Branch Sofia Eastern Branch.\n"
				+ "Successfully imported Branch Central Park Branch.\n"
				+ "Successfully imported Branch New York Central.\n"
				+ "Successfully imported Branch Sidney Central Branch.\n"
				+ "Successfully imported Branch Delhi Western Branch.\n"
				+ "Successfully imported Branch Bangalore Central Branch.\n"
				+ "Successfully imported Branch Mexico Main Branch.\n"
				+ "Successfully imported Branch Delhi Eastern Branch.\n"
				+ "Successfully imported Branch Moscow Central Branch.\n"
				+ "Successfully imported Branch Rio De Janeiro Branch.\n"
				+ "Successfully imported Branch Sofia Northern Branch.\n"
				+ "Successfully imported Branch Sofia Southern Branch.\n";
		assertEquals(expectedJson, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void getTowns() throws Exception {
		String json = "[\n" + "  {\n" + "    \"name\": \"Sofia\",\n" + "    \"population\": 2001050\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Dublin\",\n" + "    \"population\": 1214666\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Bangalore\",\n" + "    \"population\": 11882666\n"
				+ "  },	\n" + "  {\n" + "    \"name\": \"New York\",\n" + "    \"population\": 11563790\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Tokyo\",\n" + "    \"population\": 27634593\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Moscow\",\n" + "    \"population\": 4523120\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Rome\",\n" + "    \"population\": 3021333\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Madrid\",\n" + "    \"population\": 7403213\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Paris\",\n" + "    \"population\": 8900043\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Rio de Janeiro\",\n" + "    \"population\": 6345231\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Washington DC\",\n" + "    \"population\": 3204506\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Delhi\",\n" + "    \"population\": 12398421\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Sidney\",\n" + "    \"population\": 4283102\n"
				+ "  },\n" + "  {\n" + "    \"name\": \"Mexico City\",\n" + "    \"population\": 12041284\n"
				+ "  }\n" + "]";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(json, headers);

		ResponseEntity<String> response = restTemplate.exchange("/import/towns", HttpMethod.POST, entity, String.class);

		String expectedJson = "Successfully imported Town Sofia.\n" + 
				"Successfully imported Town Dublin.\n" + 
				"Successfully imported Town Bangalore.\n" + 
				"Successfully imported Town New York.\n" + 
				"Successfully imported Town Tokyo.\n" + 
				"Successfully imported Town Moscow.\n" + 
				"Successfully imported Town Rome.\n" + 
				"Successfully imported Town Madrid.\n" + 
				"Successfully imported Town Paris.\n" + 
				"Successfully imported Town Rio de Janeiro.\n" + 
				"Successfully imported Town Washington DC.\n" + 
				"Successfully imported Town Delhi.\n" + 
				"Successfully imported Town Sidney.\n" + 
				"Successfully imported Town Mexico City.\n";
		assertEquals(expectedJson, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void getEmployeeCards() throws Exception {
		String json = "[\n" + "  {\n" + "    \"number\": \"zi4n5-y41Pq-ugz5v-3vrNH-Dv21y\"\n" + "  },\n"
				+ "  {\n" + "    \"number\": \"UAIP0-0UVao-3axBt-vWF8c-45paZ\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"65RrK-NRzLZ-pJLZN-Chp3q-tovmA\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"DXKwE-pprkA-dLT9g-bGnbp-1304U\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"3mQuf-dGsVC-v5RhD-esuzu-0XcXp\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"tswrI-tDtGI-mlWBr-oKYHn-coIIF\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"ukBy1-rliJm-tMvvk-jRLtI-Z4byL\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"Jvoub-tJQim-7cIzr-lpSQM-Hfasm\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"YZkdP-LuRyn-pM6S2-gZwKP-0OK3o\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"Vy2un-LBvJU-31FsV-GbD6B-WUkBT\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"uhp39-tNbSg-6jc5P-DC8J8-6rbVN\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"uhp39-tNbSg-6jc5P-DC8J8-6rbVN\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"3C4WQ-NgARf-tsahq-GnIT6-R56nk\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"99rXG-1Ynwp-ahF4J-btmQ6-wg6d3\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"K6LQ0-idc9V-zZZrA-K9Azx-12nZa\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"Onm25-YwwpH-RPFg4-ik3lu-ZeNy8\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"fh53H-vA5Re-S7LL4-HAOwm-pkuWX\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"1wBUO-DZHZH-gjg9J-4VXr4-rLgtp\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"oMmcJ-pd1N8-qp2Of-dLsow-PDCkW\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"IsOne-INVQ5-53Hgx-idDeq-ETAbW\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"79emc-SAIDI-5GZsF-n3Sqz-7sLJb\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"rnarn-v81q4-ItpUT-ewYUu-6PGwc\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"M3Y0n-A10Ev-lCk8M-8BtnZ-25Rxv\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"s3RVh-OMpAw-zND7l-kUyi0-gAGCu\"\n" + "  },\n" + "  {\n"
				+ "    \"number\": \"8PLMI-qZWQu-LuXfz-khxc7-Y8Q9j\"\n" + "  }\n" + "]";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(json, headers);

		ResponseEntity<String> response = restTemplate.exchange("/import/employee-cards", HttpMethod.POST, entity,
				String.class);

		String expectedJson = "Successfully imported EmployeeCard zi4n5-y41Pq-ugz5v-3vrNH-Dv21y.\n"
				+ "Successfully imported EmployeeCard UAIP0-0UVao-3axBt-vWF8c-45paZ.\n"
				+ "Successfully imported EmployeeCard 65RrK-NRzLZ-pJLZN-Chp3q-tovmA.\n"
				+ "Successfully imported EmployeeCard DXKwE-pprkA-dLT9g-bGnbp-1304U.\n"
				+ "Successfully imported EmployeeCard 3mQuf-dGsVC-v5RhD-esuzu-0XcXp.\n"
				+ "Successfully imported EmployeeCard tswrI-tDtGI-mlWBr-oKYHn-coIIF.\n"
				+ "Successfully imported EmployeeCard ukBy1-rliJm-tMvvk-jRLtI-Z4byL.\n"
				+ "Successfully imported EmployeeCard Jvoub-tJQim-7cIzr-lpSQM-Hfasm.\n"
				+ "Successfully imported EmployeeCard YZkdP-LuRyn-pM6S2-gZwKP-0OK3o.\n"
				+ "Successfully imported EmployeeCard Vy2un-LBvJU-31FsV-GbD6B-WUkBT.\n"
				+ "Successfully imported EmployeeCard uhp39-tNbSg-6jc5P-DC8J8-6rbVN.\n"
				+ "Successfully imported EmployeeCard uhp39-tNbSg-6jc5P-DC8J8-6rbVN.\n"
				+ "Successfully imported EmployeeCard 3C4WQ-NgARf-tsahq-GnIT6-R56nk.\n"
				+ "Successfully imported EmployeeCard 99rXG-1Ynwp-ahF4J-btmQ6-wg6d3.\n"
				+ "Successfully imported EmployeeCard K6LQ0-idc9V-zZZrA-K9Azx-12nZa.\n"
				+ "Successfully imported EmployeeCard Onm25-YwwpH-RPFg4-ik3lu-ZeNy8.\n"
				+ "Successfully imported EmployeeCard fh53H-vA5Re-S7LL4-HAOwm-pkuWX.\n"
				+ "Successfully imported EmployeeCard 1wBUO-DZHZH-gjg9J-4VXr4-rLgtp.\n"
				+ "Successfully imported EmployeeCard oMmcJ-pd1N8-qp2Of-dLsow-PDCkW.\n"
				+ "Successfully imported EmployeeCard IsOne-INVQ5-53Hgx-idDeq-ETAbW.\n"
				+ "Successfully imported EmployeeCard 79emc-SAIDI-5GZsF-n3Sqz-7sLJb.\n"
				+ "Successfully imported EmployeeCard rnarn-v81q4-ItpUT-ewYUu-6PGwc.\n"
				+ "Successfully imported EmployeeCard M3Y0n-A10Ev-lCk8M-8BtnZ-25Rxv.\n"
				+ "Successfully imported EmployeeCard s3RVh-OMpAw-zND7l-kUyi0-gAGCu.\n"
				+ "Successfully imported EmployeeCard 8PLMI-qZWQu-LuXfz-khxc7-Y8Q9j.\n";
		assertEquals(expectedJson, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void getProducts() throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + 
				"<products>\n" + 
				"    <product name=\"Hydrogen Car Engine\" clients=\"20000\">\n" + 
				"        <branch>Tokyo Main Branch</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Chair\" clients=\"5001023\">\n" + 
				"        <branch>Central Park Branch</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Garbage Bag\" clients=\"102849\">\n" + 
				"        <branch>Headquarters</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Cyrcus Handles\" clients=\"10312\">\n" + 
				"        <branch>Delhi Western Branch</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Opera Monocle\" clients=\"10000\">\n" + 
				"        <branch>Sidney Central Branch</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Fertilizer\" clients=\"6502323\">\n" + 
				"        <branch>Mexico Main Branch</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Lantern\" clients=\"20000000\">\n" + 
				"        <branch>Bangalore Central Branch</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Telescope\" clients=\"100000\">\n" + 
				"        <branch>Dublin Central Branch</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Helicopter\" clients=\"1\">\n" + 
				"        <branch>New York Central</branch>\n" + 
				"    </product>\n" + 
				"    <product name=\"Table\" clients=\"10\">\n" + 
				"        <branch>Headquarters</branch>\n" + 
				"    </product>\n" + 
				"</products>\n";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> entity = new HttpEntity<>(xml, headers);

		ResponseEntity<String> response = restTemplate.exchange("/import/products", HttpMethod.POST, entity,
				String.class);

		String expectedJson = "Successfully imported Product Hydrogen Car Engine.\n" + 
				"Successfully imported Product Chair.\n" + 
				"Successfully imported Product Garbage Bag.\n" + 
				"Successfully imported Product Cyrcus Handles.\n" + 
				"Successfully imported Product Opera Monocle.\n" + 
				"Successfully imported Product Fertilizer.\n" + 
				"Successfully imported Product Lantern.\n" + 
				"Successfully imported Product Telescope.\n" + 
				"Successfully imported Product Helicopter.\n" + 
				"Successfully imported Product Table.\n";
		assertEquals(expectedJson, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void getEmployees() throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + 
				"<employees>\n" + 
				"    <employee firstName=\"John\" lastName=\"Winchester\" position=\"Security Manager\">\n" + 
				"        <card>zi4n5-y41Pq-ugz5v-3vrNH-Dv21y</card>\n" + 
				"        <branch>USA Main Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Leeroy\" lastName=\"Gips\" position=\"Security Manager\">\n" + 
				"        <card>3mQuf-dGsVC-v5RhD-esuzu-0XcXp</card>\n" + 
				"        <branch>Dublin Central Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Rick\" lastName=\"Sanchez\" position=\"Head Scientist\">\n" + 
				"        <card>65RrK-NRzLZ-pJLZN-Chp3q-tovmA</card>\n" + 
				"        <branch>Headquarters</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Johnathan\" lastName=\"Cane\" position=\"Secretary\">\n" + 
				"        <card>uhp39-tNbSg-6jc5P-DC8J8-6rbVN</card>\n" + 
				"        <branch>Sofia Eastern Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Rubert\" lastName=\"Down\" position=\"Cleaner\">\n" + 
				"        <card>fh53H-vA5Re-S7LL4-HAOwm-pkuWX</card>\n" + 
				"        <branch>Sidney Central Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Jake\" lastName=\"Drinkwater\" position=\"Head Biologist\">\n" + 
				"        <card>M3Y0n-A10Ev-lCk8M-8BtnZ-25Rxv</card>\n" + 
				"        <branch>Delhi Western Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Hel\" lastName=\"Midsummer\" position=\"Accountant\">\n" + 
				"        <card>3C4WQ-NgARf-tsahq-GnIT6-R56nk</card>\n" + 
				"        <branch>Rio De Janeiro Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Downey\" lastName=\"Rass\" position=\"Technical Support\">\n" + 
				"        <card>3C4WQ-NgARf-tsahq-GnIT6-R56nk</card>\n" + 
				"        <branch>New York Central</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Jefrey\" lastName=\"Hunnington\" position=\"Office Manager\">\n" + 
				"        <card>DXKwE-pprkA-dLT9g-bGnbp-1304U</card>\n" + 
				"        <branch>Bangalore Central Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Sandy\" lastName=\"Bloodred\" position=\"Security Manager\">\n" + 
				"        <card>UAIP0-0UVao-3axBt-vWF8c-45paZ</card>\n" + 
				"        <branch>Mexico Main Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Alex\" lastName=\"Mercer\" position=\"Head Security\">\n" + 
				"        <card>Vy2un-LBvJU-31FsV-GbD6B-WUkBT</card>\n" + 
				"        <branch>Central Park Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Hamilton\" lastName=\"Reign\" position=\"Marketing Manager\">\n" + 
				"        <card>Jvoub-tJQim-7cIzr-lpSQM-Hfasm</card>\n" + 
				"        <branch>Sofia Northern Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Yakushiba\" lastName=\"Nakushetka\" position=\"Chief Executive Officer\">\n" + 
				"        <card>tswrI-tDtGI-mlWBr-oKYHn-coIIF</card>\n" + 
				"        <branch>Tokyo Main Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Summer\" lastName=\"Greav\" position=\"Secretary\">\n" + 
				"        <card>Onm25-YwwpH-RPFg4-ik3lu-ZeNy8</card>\n" + 
				"        <branch>Headquarters</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Danny\" lastName=\"Goat\" position=\"Security Manager\">\n" + 
				"        <card>s3RVh-OMpAw-zND7l-kUyi0-gAGCu</card>\n" + 
				"        <branch>Some Branch</branch>\n" + 
				"    </employee>\n" + 
				"    <employee firstName=\"Smite\" lastName=\"Daphny\" position=\"Cleaner\">\n" + 
				"        <card>K6LQ0-idc9V-zZZrA-K9Azx-12nZa</card>\n" + 
				"        <branch>Moscow Central Branch</branch>\n" + 
				"    </employee>\n" + 
				"</employees>\n";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> entity = new HttpEntity<>(xml, headers);

		ResponseEntity<String> response = restTemplate.exchange("/import/employees", HttpMethod.POST, entity,
				String.class);

		String expectedJson = "Successfully imported Employee JohnWinchester.\n" + 
				"Successfully imported Employee LeeroyGips.\n" + 
				"Successfully imported Employee RickSanchez.\n" + 
				"Successfully imported Employee JohnathanCane.\n" + 
				"Successfully imported Employee RubertDown.\n" + 
				"Successfully imported Employee JakeDrinkwater.\n" + 
				"Successfully imported Employee HelMidsummer.\n" + 
				"Successfully imported Employee DowneyRass.\n" + 
				"Successfully imported Employee JefreyHunnington.\n" + 
				"Successfully imported Employee SandyBloodred.\n" + 
				"Successfully imported Employee AlexMercer.\n" + 
				"Successfully imported Employee HamiltonReign.\n" + 
				"Successfully imported Employee YakushibaNakushetka.\n" + 
				"Successfully imported Employee SummerGreav.\n" + 
				"Successfully imported Employee DannyGoat.\n" + 
				"Successfully imported Employee SmiteDaphny.\n";
		assertEquals(expectedJson, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}
}
