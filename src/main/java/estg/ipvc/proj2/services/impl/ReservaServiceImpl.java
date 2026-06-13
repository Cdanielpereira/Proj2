package estg.ipvc.proj2.services.impl;

import estg.ipvc.proj2.dtos.common.PageMapper;
import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.reservadto.ReservaDto;
import estg.ipvc.proj2.dtos.reservadto.ReservaMapper;
import estg.ipvc.proj2.exceptions.EntityNotFoundException;
import estg.ipvc.proj2.model.Marcacao;
import estg.ipvc.proj2.model.Quarto;
import estg.ipvc.proj2.model.Reserva;
import estg.ipvc.proj2.model.ReservaId;
import estg.ipvc.proj2.repository.MarcacaoRepository;
import estg.ipvc.proj2.repository.QuartoRepository;
import estg.ipvc.proj2.repository.ReservaRepository;
import estg.ipvc.proj2.services.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final MarcacaoRepository marcacaoRepository;
    private final QuartoRepository quartoRepository;

    @Autowired
    public ReservaServiceImpl(
            ReservaRepository reservaRepository,
            MarcacaoRepository marcacaoRepository,
            QuartoRepository quartoRepository) {

        this.reservaRepository = reservaRepository;
        this.marcacaoRepository = marcacaoRepository;
        this.quartoRepository = quartoRepository;
    }

    @Override
    public ReservaDto createReserva(ReservaDto dto) {

        Marcacao marcacao = marcacaoRepository.findById(dto.getIdMarc())
                .orElseThrow(() -> new EntityNotFoundException("Marcação não encontrada"));

        Quarto quarto = quartoRepository.findById(dto.getNquarto())
                .orElseThrow(() -> new EntityNotFoundException("Quarto não encontrado"));

        Reserva reserva = ReservaMapper.toEntity(dto);

        reserva.setId(new ReservaId(
                dto.getIdMarc(),
                dto.getNquarto()
        ));

        reserva.setIdMarc(marcacao);
        reserva.setNquarto(quarto);

        return ReservaMapper.toDto(
                reservaRepository.save(reserva)
        );
    }

    @Override
    public PageResponse<ReservaDto> getAllReservas(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Reserva> page = reservaRepository.findAll(pageable);

        return PageMapper.toPageResponse(page, ReservaMapper::toDto);
    }

    @Override
    public ReservaDto getReservaById(Integer idMarc, Integer nquarto) {

        ReservaId id = new ReservaId(idMarc, nquarto);

        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));

        return ReservaMapper.toDto(reserva);
    }

    @Override
    public ReservaDto updateReserva(ReservaDto dto, Integer idMarc, Integer nquarto) {

        ReservaId id = new ReservaId(idMarc, nquarto);

        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));

        reserva.setPrecoatual(dto.getPrecoatual());
        reserva.setIvaatual(dto.getIvaatual());

        return ReservaMapper.toDto(
                reservaRepository.save(reserva)
        );
    }

    @Override
    public void deleteReserva(Integer idMarc, Integer nquarto) {

        ReservaId id = new ReservaId(idMarc, nquarto);

        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));

        reservaRepository.delete(reserva);
    }
}