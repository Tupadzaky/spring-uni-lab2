package lab2.controller;

import io.swagger.v3.oas.annotations.Operation;
import lab2.dto.request.GradeRequestDto;
import lab2.dto.request.JournalRequestDto;
import lab2.dto.response.GradeResponseDto;
import lab2.dto.response.JournalResponseDto;
import lab2.mapper.JournalMapper;
import lab2.model.Grade;
import lab2.model.Journal;
import lab2.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
@RequiredArgsConstructor
public class JournalController {
    private final AbstractService<Journal> journalService;
    private final JournalMapper journalMapper;

    @Operation(summary = "Get all journals", description = "List of all journals")
    @GetMapping
    public List<JournalResponseDto> findAll() {
        return journalService.findAll().stream()
                .map(journalMapper::journalToJournalDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Get journal by id", description = "Get journal by id")
    @GetMapping("/{id}")
    public JournalResponseDto findById(@PathVariable Long id) {
        return journalMapper.journalToJournalDto(journalService.findById(id));
    }

    @Operation(summary = "Create journal", description = "Create journal")
    @PostMapping
    public JournalResponseDto save(@RequestBody JournalRequestDto requestDto) {
        return journalMapper.journalToJournalDto(journalService.save(journalMapper.journalRequestToJournal(requestDto)));
    }

    @Operation(summary = "Update journal by id", description = "Update journal by id")
    @PutMapping("/{id}")
    public JournalResponseDto update(@PathVariable Long id, @RequestBody JournalRequestDto requestDto) {
        Journal journal = journalService.update(journalMapper.journalRequestToJournal(requestDto));
        journal.setId(id);
        return journalMapper.journalToJournalDto(journalService.update(journal));
    }

    @Operation(summary = "Delete journal by id", description = "Delete journal by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        journalService.deleteById(id);
    }
}
