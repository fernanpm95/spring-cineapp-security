package fernando.learn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fernando.learn.app.model.Banner;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer> {

}
