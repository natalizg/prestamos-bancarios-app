package com.beginsecure.PrestamosBancariosApp.repository;

import com.beginsecure.PrestamosBancariosApp.domain.SolicitudPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Long> {
}
