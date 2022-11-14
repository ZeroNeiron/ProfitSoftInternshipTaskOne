package org.example.service.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.example.service.TextService;

public class TextServiceImpl implements TextService {
    @Override
    public Map<String, Long> findMostPopularHashtags(List<String> lines, Integer number) {
        return lines.stream()
                .flatMap(l -> Pattern.compile("(#+[a-zA-Z0-9(_)]{1,})")
                        .matcher(l)
                        .results()
                        .map(MatchResult::group)
                        .distinct())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(number)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
