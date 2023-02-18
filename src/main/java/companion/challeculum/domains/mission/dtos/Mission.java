package companion.challeculum.domains.mission.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Mission {
    private long id;
    private long groundId;
    private String assignment;
    private LocalDate startAt;
    private LocalDate endAt;
}