package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import blacksmith.sullivanwayserver.model.TimeTable.PK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "time_table")
@IdClass(PK.class)
public class TimeTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3256373227015341915L;

	@Id
    @Column(name = "line_id", nullable = false)
    public Long lineId; //호선 ID

	@Id
    @Column(name = "start_stn_id", nullable = false)
    public Long startStnId; //운행 시작역 ID

	@Id
    @Column(name = "end_stn_id", nullable = false)
    public Long endStnId; //운행 종착역 ID
    
	@Id
    @Column(name = "up_down_type", nullable = false)
    public Integer upDownType; //상하행 (1: 상/내, 2: 하/외)

	@Id
    @Column(name = "week_type", nullable = false)
    public Integer weekType; //주중주말 (1: 평일, 2: 토, 3: 일/공)

	@Id
    @Column(name = "seq_num", nullable = false)
    public Integer seqNum; //순번

    @Column(name = "subway_type", nullable = false)
    public Integer subwayType; //급행여부 (1: 일반, 2: 급행)

    public String time; //현재 역에서 출발하는 시간 (HHmmss)
    
    class PK implements Serializable {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 2287642079238266481L;
		public Long lineId;
    	public Long startStnId;
    	public Long endStnId;
    	public Integer upDownType;
    	public Integer weekType;
    	public Integer seqNum;
    }
}
