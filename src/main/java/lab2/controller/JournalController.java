package lab2.controller;

import java.util.List;
import java.util.stream.Collectors;

import lab2.dto.response.JournalDto;
import lab2.mapper.JournalMapper;
import lab2.model.Journal;
import lab2.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journal")
@RequiredArgsConstructor
public class JournalController {
    private AbstractService<Journal> journalService;
    private JournalMapper journalMapper;

    @GetMapping
    public List<JournalDto> findAll() {
        return journalService.findAll().stream()
                .map(journalMapper::journalToJournalDto)
                .collect(Collectors.toList());
    }
}
