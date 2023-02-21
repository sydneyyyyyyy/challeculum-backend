package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GroundDao {

//   Ki Young
    Ground getDepositById(long groundId);
// End of Ki Young
    void deleteGround(long groundId);

    Ground getGround(long groundId);

    List<Map<String,Object>> getGroundList(@Param("startRow") Integer startRow,
                                     @Param("limit") int limit,
                                     @Param("filterMap") Map<String, String> filterMap,
                                     @Param("sortBy") String sortBy,
                                     @Param("orderBy") String orderBy,
                                     @Param("keyword") String keyword);

    List<Map<String, Object>> getGroundsByMe(long userId);

    void createGround(GroundCreateDto groundCreateDTO);

    List<Map<String,Object>> getMyGroundList(@Param("userId") long userId,
                                               @Param("startRow") Integer startRow,
                                               @Param("ROWS_PER_PAGE") int rowsPerPage,
                                               @Param("status") String status);

    void refundDeposit(long groundId);

    void markNotAttending(long groundId);

    int updateGround(@Param("groundId") long groundId, @Param("updateMap") Map<String,Object> updateMap);

    Long getGroundCreator(long groundId);

    List<Map<String, Object>> getMyGrounds(long userId);
}
