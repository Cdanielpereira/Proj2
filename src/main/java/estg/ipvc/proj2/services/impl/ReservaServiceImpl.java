package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.model.Reserva;
import estg.ipvc.proj2.model.ReservaId;
import estg.ipvc.proj2.repository.ReservaRepository;
import estg.ipvc.proj2.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        List<Reserva> reservas = new ArrayList<>();
        for (Reserva reserva : reservaRepository.findAll()) {
            reservas.add(reserva);
        }
        return reservas;
    }

    public Optional<Reserva> getReservaById(Integer idMarc, Integer nquarto) {
        ReservaId id = new ReservaId();
        id.setIdMarc(idMarc);
        id.setNquarto(nquarto);
        return reservaRepository.findById(id);
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Integer idMarc, Integer nquarto, Reserva reserva) {
        ReservaId id = new ReservaId();
        id.setIdMarc(idMarc);
        id.setNquarto(nquarto);
        if (reservaRepository.existsById(id)) {
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public void deleteReserva(Integer idMarc, Integer nquarto) {
        ReservaId id = new ReservaId();
        id.setIdMarc(idMarc);
        id.setNquarto(nquarto);
        reservaRepository.deleteById(id);
    }

    public boolean reservaExists(Integer idMarc, Integer nquarto) {
        ReservaId id = new ReservaId();
        id.setIdMarc(idMarc);
        id.setNquarto(nquarto);
        return reservaRepository.existsById(id);
    }
}

