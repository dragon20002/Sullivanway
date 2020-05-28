package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "subway_line")
public class SubwayLine implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -5826402185913410343L;

	@Id
    public Long id;
    
    public String name; //호선명
    
    @Column(name = "symbol_res_id")
    public Long symbolResId; //호선 심볼 리소스 ID
    
    @Column(name = "color_res_id")
    public Long colorResId; //호선 색 리소스 ID
    
    @Column(name = "icon_res_id")
    public Long iconResId; //호선 아이콘 리소스 ID
    
    @Column(name = "bg_res_id")
    public Long bgResId; //호선 아이콘 배경 리소스 ID
}
