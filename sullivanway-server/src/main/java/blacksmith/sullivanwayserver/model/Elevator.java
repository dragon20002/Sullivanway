package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import blacksmith.sullivanwayserver.model.Elevator.PK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "elevator")
@IdClass(PK.class)
public class Elevator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4613984711796202098L;

	@Id
    @Column(name = "stn_id", nullable = false)
    public Long stnId; //역 ID

	@Id
    @Column(name = "seq_num", nullable = false)
    public Integer seqNum; //순번

    @Column(name = "in_out_type")
    public Integer inOutType; //내외부 유형 (1: 내부, 2: 외부)

    @Column(name = "top_floor")
    public Integer topFloor; //최상층 층

    @Column(name = "top_floor_type")
    public Integer topFloorType; //최상층 유형 (1: 승강장, 2: 대합실, 3: 지상, 4: 상가)

    @Column(name = "bottom_floor")
    public Integer bottomFloor; //최하층 층

    @Column(name = "bottom_floor_type")
    public Integer bottomFloorType; //최하층 유형 (1: 승강장, 2: 대합실, 3: 지상, 4: 상가)

    public String location; //상세위치 내용
    
	class PK implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8860264227460267887L;
		public Long stnId;
		public Integer seqNum;
	}
}
