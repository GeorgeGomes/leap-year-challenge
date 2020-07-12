package com.challenge.leapYear;

import com.challenge.leapYear.config.MessagesHandler;
import com.challenge.leapYear.domain.CalculateLeapYear;
import com.challenge.leapYear.domain.CalculateYear;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class YearTest {

	@Autowired
	private MessagesHandler messagesHandler;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldReturnLeapYearTrue() throws Exception {
		//arrange
		CalculateYear calculateLeapYear = new CalculateLeapYear();

		//act
		boolean isLeapYear2008 = calculateLeapYear.calc(2008);
		boolean isLeapYear1944 = calculateLeapYear.calc(1944);
		boolean isLeapYear1888 = calculateLeapYear.calc(1888);
		boolean isLeapYear1732 = calculateLeapYear.calc(1732);
		boolean isLeapYear1600 = calculateLeapYear.calc(1600);

		//assert
		assertTrue("Ano 2008 é bissexto", isLeapYear2008);
		assertTrue("Ano 1944 é bissexto", isLeapYear1944);
		assertTrue("Ano 1888 é bissexto", isLeapYear1888);
		assertTrue("Ano 1732 é bissexto", isLeapYear1732);
		assertTrue("Ano 1600 é bissexto", isLeapYear1600);

	}

	@Test
	public void shouldReturnLeapYearFalse() throws Exception {
		//arrange
		CalculateYear calculateLeapYear = new CalculateLeapYear();

		//act
		boolean isLeapYear2011 = calculateLeapYear.calc(2011);
		boolean isLeapYear1951 = calculateLeapYear.calc(1951);
		boolean isLeapYear1889 = calculateLeapYear.calc(1889);
		boolean isLeapYear1742 = calculateLeapYear.calc(1742);

		//assert
		assertFalse("Ano 2011 não é bissexto", isLeapYear2011);
		assertFalse("Ano 1951 não é bissexto", isLeapYear1951);
		assertFalse("Ano 1889 não é bissexto", isLeapYear1889);
		assertFalse("Ano 1742 não é bissexto", isLeapYear1742);
	}

}
