package ru.touragency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.touragency.dto.RequestCreateForm;
import ru.touragency.entity.TouristRequest;
import ru.touragency.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class TouristRequestService {
    private final TouristRequestRepository requests;
    private final ClientRepository clients;
    private final ManagerRepository managers;
    private final DirectionRepository directions;
    private final RequestStatusRepository statuses;

    public TouristRequestService(TouristRequestRepository requests, ClientRepository clients, ManagerRepository managers,
                                DirectionRepository directions, RequestStatusRepository statuses) {
        this.requests = requests;
        this.clients = clients;
        this.managers = managers;
        this.directions = directions;
        this.statuses = statuses;
    }

    public List<TouristRequest> findAll() { return requests.findAll(); }
    public TouristRequest findById(Integer id) { return requests.findById(id).orElseThrow(); }

    @Transactional
    public TouristRequest create(RequestCreateForm form) {
        TouristRequest request = new TouristRequest();
        request.setClient(clients.findById(form.getClientId()).orElseThrow());
        request.setManager(managers.findById(form.getManagerId()).orElseThrow());
        request.setDirection(directions.findById(form.getDirectionName()).orElseThrow());
        request.setStatus(statuses.findAll().stream().findFirst().orElseThrow());
        request.setRequestDate(LocalDate.now());
        request.setTouristsCount(form.getTouristsCount());
        request.setPlannedBudget(form.getPlannedBudget());
        request.setManagerComment(form.getManagerComment());
        return requests.save(request);
    }
}
