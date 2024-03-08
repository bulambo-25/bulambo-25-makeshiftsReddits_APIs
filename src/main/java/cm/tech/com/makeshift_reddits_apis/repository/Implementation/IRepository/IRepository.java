package cm.tech.com.makeshift_reddits_apis.repository.Implementation.IRepository;


public interface IRepository <T,ID>  {
    T create(T t);
    T getById(Long id);
    void deleteById(Long id);

}