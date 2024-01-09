package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Assistant;

public interface AssistantService {
    List<Assistant> getAllAssistants();
    Assistant getAssistantById(Long id);
    Assistant createAssistant(Assistant assistant);
    Assistant updateAssistant(Long id, Assistant assistant);
    void deleteAssistant(Long id);
}
