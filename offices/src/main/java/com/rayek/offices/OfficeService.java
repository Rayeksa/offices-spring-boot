package com.rayek.offices;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    // عرض كل المكاتب
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    // إضافة مكتب
    public Office addOffice(Office office) {
        return officeRepository.save(office);
    }

    // جلب مكتب برقمه
    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElseThrow();
    }

    // حذف مكتب
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }

    // تعديل مكتب
    public Office updateOffice(Long id, Office newData) {
        Office office = officeRepository.findById(id).orElseThrow();
        office.setTower(newData.getTower());
        office.setFloorNumber(newData.getFloorNumber());
        office.setOfficeNumber(newData.getOfficeNumber());
        office.setWing(newData.getWing());
        office.setArea(newData.getArea());
        office.setStatus(newData.getStatus());
        office.setTenantName(newData.getTenantName());
        office.setStartDate(newData.getStartDate());
        office.setEndDate(newData.getEndDate());
        return officeRepository.save(office);
    }

    // تأجير مكتب: ممنوع لو مؤجر أصلا
    public Office rentOffice(Long id, String tenantName) {
        Office office = officeRepository.findById(id).orElseThrow();

        if (office.getStatus().equals("RENTED")) {
            throw new RuntimeException("المكتب مؤجر أصلا");
        }

        office.setStatus("RENTED");
        office.setTenantName(tenantName);
        return officeRepository.save(office);
    }
}