package org.example.service;

import java.util.List;
import java.util.Map;

public interface TextService {
    Map<String, Long> findMostPopularHashtags(List<String> lines, Integer number);
}
