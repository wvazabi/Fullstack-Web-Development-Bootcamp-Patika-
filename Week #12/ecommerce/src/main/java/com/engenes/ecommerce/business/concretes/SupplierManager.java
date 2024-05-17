package com.engenes.ecommerce.business.concretes;

import com.engenes.ecommerce.business.abstracts.ISupplierService;
import com.engenes.ecommerce.core.exception.NotFoundException;
import com.engenes.ecommerce.core.utilies.Msg;
import com.engenes.ecommerce.dao.SupplierRepo;
import com.engenes.ecommerce.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierManager implements ISupplierService {

    //dependence ınjection yapıyoruz
    private final SupplierRepo supplierRepo;

    public SupplierManager(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return this.supplierRepo.save(supplier);
    }

    @Override
    public Supplier get(int id) {
        return this.supplierRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Supplier> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.supplierRepo.findAll(pageable);
    }

    @Override
    public Supplier update(Supplier supplier) {
        this.get(supplier.getId());
        return this.supplierRepo.save(supplier);
    }


    @Override
    public boolean delete(int id) {
      Supplier supplier = this.get(id);
      this.supplierRepo.delete(supplier);
      return true;
    }
}
