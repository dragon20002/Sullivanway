package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import blacksmith.sullivanwayserver.model.TransferMap.PK;

@Entity(name = "transfer_map")
@IdClass(PK.class)
public class TransferMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6096917755075638202L;

	@Id
    @Column(name = "start_stn_id", nullable = false)
    public Long startStnId; //출발역 ID

	@Id
    @Column(name = "end_stn_id", nullable = false)
    public Long endStnId; //도착역 ID

	@Id
    @Column(name = "start_up_down_type", nullable = false)
    public Integer startUpDownType; //출발역 상하행 유형

	@Id
    @Column(name = "end_up_down_type", nullable = false)
    public Integer endUpDownType; //도착역 상하행 유형

	@Id
    @Column(nullable = false)
    public Integer floor; //현재 층

    @Column(name = "res_id")
    public Long resId; //환승지도 리소스 ID
    
    public Integer time; //소요시간(분)
    
    class PK implements Serializable {
    	/**
		 * 
		 */
		private static final long serialVersionUID = -7677759460078408356L;
		public Long startStnId;
    	public Long endStnId;
    	public Integer startUpDownType;
    	public Integer endUpDownType;
    	public Integer floor;
    }
}
