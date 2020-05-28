package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "station_detail")
public class StationDetail implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6890399467630783585L;

	@Id
    @Column(name = "stn_id")
    public Long stnId; //역 ID

    public Double distance; //다음 역까지 거리(KM)

    @Column(name = "wgs_x")
    public Double wgsX; //WGS-X 좌표

    @Column(name = "wgs_y")
    public Double wgsY; //WGS-Y 좌표

    
    public Integer door; //문 방향 (1: 왼쪽, 2: 오른쪽)

    
    public String contact; //연락처

    
    public Integer toilet; //화장실 위치 (1: 안쪽, 2: 바깥쪽)

    
    public Integer elevator; //엘리베이터 여부 (1: Yes, 2: No)

    
    public Integer escalator; //에스컬레이터 여부 (1: Yes, 2: No)

    
    @Column(name = "wheel_lift")
    public Integer wheelLift; //휠체어리프트 여부 (1: Yes, 2: No)
}
