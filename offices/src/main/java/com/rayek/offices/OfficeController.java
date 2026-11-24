package com.rayek.offices;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    // GET /offices
    @GetMapping
    public List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    // POST /offices
    @PostMapping
    public Office addOffice(@RequestBody Office office) {
        return officeService.addOffice(office);
    }

    // GET /offices/1
    @GetMapping("/{id}")
    public Office getOfficeById(@PathVariable Long id) {
        return officeService.getOfficeById(id);
    }

    // DELETE /offices/1
    @DeleteMapping("/{id}")
    public void deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);
    }

    // PUT /offices/1
    @PutMapping("/{id}")
    public Office updateOffice(@PathVariable Long id, @RequestBody Office newData) {
        return officeService.updateOffice(id, newData);
    }

    // PUT /offices/1/rent?tenantName=Ahmed
    @PutMapping("/{id}/rent")
    public Office rentOffice(@PathVariable Long id, @RequestParam String tenantName) {
        return officeService.rentOffice(id, tenantName);
    }
}