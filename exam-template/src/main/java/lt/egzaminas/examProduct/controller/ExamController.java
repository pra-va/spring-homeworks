package lt.egzaminas.examProduct.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exam")
public class ExamController {
	private static final Logger LOGGER = LogManager.getLogger(ExamController.class);

}
