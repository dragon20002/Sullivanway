package blacksmith.sullivanwayserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "subway_node")
public class SubwayNode implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4023671912660502008L;

	@Id
    public Long id;
    
    public String name; //역 이름
    
    public Integer x; //가로 터치 위치
    
    public Integer y; //세로 터치 위치
}
