package clinicapp.service.serviceimpl;

import clinicapp.dao.AnalysisDAO;

import clinicapp.entity.Analysis;
import clinicapp.service.AnalysisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {

    private AnalysisDAO analysisDAO;

    public void setAnalysisDAO(AnalysisDAO analysisDAO) {
        this.analysisDAO = analysisDAO;
    }

    @Override
    @Transactional
    public void create(Analysis a) {
        this.analysisDAO.create(a);
    }

    @Override
    @Transactional
    public Analysis getById(Long id) {
        return this.analysisDAO.getById(id);
    }

    @Override
    @Transactional
    public Analysis getByDate(String date) {
        return this.analysisDAO.getByDate(date);
    }

    @Override
    @Transactional
    public List<Analysis> getAll() {
        return this.analysisDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Analysis a) {
        this.analysisDAO.update(a);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.analysisDAO.delete(id);
    }
}
