package com.example.a03_deber.ui.status

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03_deber.databinding.FragmentStatusBinding
import com.example.a03_deber.ui.chats.Chat
import com.example.a03_deber.ui.chats.ChatsAdapter
class StatusFragment : Fragment() {

    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val statusList = listOf(
            Status("https://randomuser.me/api/portraits/men/1.jpg", "Mi Estado", false),
            Status("https://randomuser.me/api/portraits/women/2.jpg", "Jane Smith", true),
            Status("https://randomuser.me/api/portraits/men/3.jpg", "Sam Wilson", false),
            Status("https://randomuser.me/api/portraits/women/4.jpg", "Emily Clark", true),
            Status("https://randomuser.me/api/portraits/men/5.jpg", "Michael Brown", false),
            Status("https://randomuser.me/api/portraits/women/6.jpg", "Linda Johnson", true),
            Status("https://randomuser.me/api/portraits/men/7.jpg", "Robert Davis", false),
            Status("https://randomuser.me/api/portraits/women/8.jpg", "Patricia Garcia", true),
            Status("https://randomuser.me/api/portraits/men/9.jpg", "James Rodriguez", false),
            Status("https://randomuser.me/api/portraits/women/10.jpg", "Mary Martinez", true),
            Status("https://randomuser.me/api/portraits/men/11.jpg", "Christopher Hernandez", false),
            Status("https://randomuser.me/api/portraits/women/12.jpg", "Elizabeth Lopez", true),
            Status("https://randomuser.me/api/portraits/men/13.jpg", "Thomas Hill", false),
            Status("https://randomuser.me/api/portraits/women/14.jpg", "Barbara Allen", true),
            Status("https://randomuser.me/api/portraits/men/15.jpg", "David Wright", false),
            Status("https://randomuser.me/api/portraits/women/16.jpg", "Jennifer Scott", true),
            Status("https://randomuser.me/api/portraits/men/17.jpg", "William Green", false),
            Status("https://randomuser.me/api/portraits/women/18.jpg", "Susan Adams", true),
            Status("https://randomuser.me/api/portraits/men/19.jpg", "Joseph Baker", false),
            Status("https://randomuser.me/api/portraits/women/20.jpg", "Nancy Gonzalez", true)
        )

        // Datos para los canales (usando el mismo ChatAdapter)
        val channelList = listOf(
            Chat("https://flyclipart.com/thumb2/netflix-logo-png-transparent-image-png-arts-82874.png", "Netflix", "Streaming service"),
            Chat("https://th.bing.com/th/id/R.b8a2c470c606be91b876296885ebbc51?rik=iX2uk1zp0Gjx1g&riu=http%3a%2f%2flogos-download.com%2fwp-content%2fuploads%2f2016%2f05%2fFC_Barcelona_logo_logotipo_crest.png&ehk=6lReaFnABLTT3wsikQrC%2bnyKhYkVRbRJSJtXMXCtUxA%3d&risl=&pid=ImgRaw&r=0", "FC Barcelona", "Football club"),
            Chat("https://static.vecteezy.com/system/resources/previews/027/395/710/non_2x/twitter-brand-new-logo-3-d-with-new-x-shaped-graphic-of-the-world-s-most-popular-social-media-free-png.png", "X", "Social media"),
            Chat("https://logodownload.org/wp-content/uploads/2014/09/facebook-logo-1-2.png", "Facebook", "Social media"),
            Chat("https://th.bing.com/th/id/OIP.-ZirgQE5pr8e7htQWowJIgHaHa?rs=1&pid=ImgDetMain", "Instagram", "Social media"),
            Chat("https://th.bing.com/th/id/R.6de2b97bcc24e8517c80d800661a92ac?rik=2Duwlf53hIW%2bhw&riu=http%3a%2f%2ftous-logos.com%2fwp-content%2fuploads%2f2017%2f08%2fSnapchat-Logo.png&ehk=M3UMd8pavs3ucC473o8kriWbyYAFWCfjiwfhhXxDioo%3d&risl=&pid=ImgRaw&r=0", "Snapchat", "Social media"),
            Chat("https://static.vecteezy.com/system/resources/previews/021/460/490/original/linkedin-logo-free-download-free-png.png", "LinkedIn", "Professional network"),
            Chat("https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Spotify_App_Logo.svg/2048px-Spotify_App_Logo.svg.png", "Spotify", "Music streaming"),
            Chat("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/2560px-Apple_logo_black.svg.png", "Apple", "Technology company"),
            Chat("https://www.pngall.com/wp-content/uploads/13/Google-Logo.png", "Google", "Search engine"),
            Chat("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Amazon_logo.svg/2560px-Amazon_logo.svg.png", "Amazon", "E-commerce"),
            Chat("https://logodownload.org/wp-content/uploads/2017/04/adobe-logo-1-1.png", "Adobe", "Software company"),
            Chat("https://th.bing.com/th/id/R.c1a0eb78a61ee2a716f42199e557ddee?rik=kndbyUmOT1TW3w&riu=http%3a%2f%2f1000logos.net%2fwp-content%2fuploads%2f2017%2f05%2fRed-Bull-emblems.jpg&ehk=ayxM3bJsrTTVVibqeJO0%2bg9EMjhlBVaXPed1OPBUnC4%3d&risl=&pid=ImgRaw&r=0", "Red Bull", "Energy drink"),
            Chat("https://th.bing.com/th/id/R.d38cbff6cc6a8194ccbfbb2815f0c6ce?rik=MhdPoabeIl65Fw&riu=http%3a%2f%2fwww.pixelstalk.net%2fwp-content%2fuploads%2f2015%2f12%2fNike-logo-wallpaper-red-black.jpg&ehk=jLaLI9XUMlk8EGkNR5tICJfYdrAQ1cuL%2fLHi9iKmn2U%3d&risl=&pid=ImgRaw&r=0", "Nike", "Sportswear"),
            Chat("https://th.bing.com/th/id/R.8dd6be8c6ab596e1603b5c75bf56386c?rik=bqaA8uifs6wULA&riu=http%3a%2f%2fpngimg.com%2fuploads%2fadidas%2fadidas_PNG8.png&ehk=m2DMwH648DIRvYaIrne9pnSXw5cPCwDYah%2b4FJSueOs%3d&risl=&pid=ImgRaw&r=0", "Adidas", "Sportswear"),
            Chat("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Microsoft_logo.svg/2560px-Microsoft_logo.svg.png", "Microsoft", "Technology company"),

        )


        // Configura el RecyclerView para estados
        binding.recyclerViewStatuses.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewStatuses.adapter = StatusAdapter(statusList)

        // Configura el RecyclerView para canales
        binding.recyclerViewChannels.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewChannels.adapter = ChatsAdapter().apply {
            submitList(channelList)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
