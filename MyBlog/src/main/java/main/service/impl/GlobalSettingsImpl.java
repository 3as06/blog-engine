package main.service.impl;

import main.repository.GlobalSettingsRepository;
import main.service.GlobalSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GlobalSettingsImpl implements GlobalSettingsService {
    @Autowired
    private GlobalSettingsRepository globalSettingsRepository;


    @Override
    public HashMap<String, String> getSettings() {
        HashMap<String, String> response = new HashMap<>();
        for (int i = 1; i <= globalSettingsRepository.count(); i++) {
            if (globalSettingsRepository.findById(i).get().getSettingsValue().equals("YES")) {
                response.put(globalSettingsRepository.findById(i).get().getSettingsCode(), "true");
            } else {
                response.put(globalSettingsRepository.findById(i).get().getSettingsCode(), "false");
            }
        }
    return response;
    }
}
