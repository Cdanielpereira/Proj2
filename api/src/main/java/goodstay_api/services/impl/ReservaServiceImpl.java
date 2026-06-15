package goodstay_api.services.impl;

import goodstay_api.dtos.common.PageMapper;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.reservadto.ReservaDto;
import goodstay_api.dtos.reservadto.ReservaMapper;
import goodstay_api.exceptions.EntityNotFoundException;
import goodstay_api.model.Marcacao;
import goodstay_api.model.Quarto;
import goodstay_api.model.Reserva;
import goodstay_api.model.ReservaId;
import goodstay_api.repository.MarcacaoRepository;
import goodstay_api.repository.QuartoRepository;
import goodstay_api.repository.ReservaRepository;
import goodstay_api.services.ReservaService;

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