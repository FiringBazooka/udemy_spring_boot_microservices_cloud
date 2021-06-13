package com.spring.api.demo3.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.demo3.LogOutput;
import com.spring.api.demo3.pojo.Releases;
import com.spring.api.demo3.service.ReleaseService;

@RestController
@RequestMapping("/release")
public class ReleaseResource {

	@Autowired
	private ReleaseService service;

	@GetMapping("/list")
	public List<Releases> getReleaseDetails() {

		List<Releases> releaseDetailsList = service.getAllReleasesDetails();
		releaseDetailsList.forEach(release -> {
			if (release.getDate().isBefore(LocalDateTime.now())) {
				release.setStatus("Production");
			} else {
				release.setStatus("Testing");
			}
		});
		;
		return releaseDetailsList;

	}

	@PostMapping("/add")
	@LogOutput
	public Releases addARelease(@RequestBody Releases input) {
		System.out.println(input.toString());

		return service.saveARelease(input);
	}

}
